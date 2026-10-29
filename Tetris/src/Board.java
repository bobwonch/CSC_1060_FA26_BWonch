import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
    public static final int WIDTH = 12;
    public static final int HEIGHT = 24;

    private Color[][] well;
    private ArrayList<Integer> bag = new ArrayList<>();
    private long score;
    private Tetromino nextPiece; // ─── ADD THIS VARIABLE ───

    public Board() {
        initBoard();
    }

    public void initBoard() {
        well = new Color[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                well[i][j] = Color.BLACK;
            }
        }
        score = 0;
        bag.clear();
        
        // ─── INITIALIZE BAG AND NEXT PIECE AHEAD OF TIME ───
        generateBagIfNeeded();
        nextPiece = new Tetromino(bag.remove(0));
    }

    private void generateBagIfNeeded() {
        if (bag.isEmpty()) {
            for (int i = 0; i < 7; i++) bag.add(i);
            Collections.shuffle(bag);
        }
    }

    // ─── UPDATE THIS METHOD ───
    public Tetromino spawnNextPiece() {
        // The current "next piece" becomes the active piece
        Tetromino current = nextPiece;
        
        // Roll a fresh upcoming piece into the queue
        generateBagIfNeeded();
        nextPiece = new Tetromino(bag.remove(0));
        
        return current;
    }

    // ─── ADD THIS GETTER ───
    public Tetromino getNextPiece() {
        return nextPiece;
    }

    // ... (Keep collides, fixToWell, and clearRows exactly the same as before)
    public boolean collides(int targetX, int targetY, int[] shape, int matrixSize) {
        for (int i = 0; i < shape.length; i++) {
            if (shape[i] == 0) continue;
            int px = targetX + (i % matrixSize) - 1;
            int py = targetY + (i / matrixSize);
            if (px < 0 || px >= WIDTH || py >= HEIGHT) return true;
            if (py >= 0 && well[px][py] != Color.BLACK) return true;
        }
        return false;
    }

    public void fixToWell(Tetromino piece) {
        int[] shape = piece.getShape();
        int n = piece.getMatrixSize();
        for (int i = 0; i < shape.length; i++) {
            if (shape[i] == 0) continue;
            int px = piece.getX() + (i % n) - 1;
            int py = piece.getY() + (i / n);
            if (py >= 0 && py < HEIGHT && px >= 0 && px < WIDTH) {
                well[px][py] = piece.getColor();
            }
        }
        clearRows();
    }

    private void clearRows() {
        int cleared = 0;
        for (int y = HEIGHT - 1; y >= 0; y--) {
            boolean full = true;
            for (int x = 0; x < WIDTH; x++) {
                if (well[x][y] == Color.BLACK) {
                    full = false;
                    break;
                }
            }
            if (full) {
                for (int ty = y; ty > 0; ty--) {
                    for (int tx = 0; tx < WIDTH; tx++) {
                        well[tx][ty] = well[tx][ty - 1];
                    }
                }
                for (int tx = 0; tx < WIDTH; tx++) {
                    well[tx][0] = Color.BLACK;
                }
                cleared++;
                y++;
            }
        }
        if (cleared > 0) {
            score += cleared * 100 * cleared;
        }
    }

    public Color[][] getWell() { return well; }
    public long getScore() { return score; }
}

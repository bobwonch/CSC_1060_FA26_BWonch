import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

public class Tetris extends JPanel {

    private final int BOARD_WIDTH = 12;
    private final int BOARD_HEIGHT = 24;
    private final Color[] colors = {
        Color.decode("#0effff"), Color.decode("#0000ff"), Color.decode("#ffaa00"),
        Color.decode("#ffff00"), Color.decode("#00ff00"), Color.decode("#aa00aa"),
        Color.decode("#ff0000")
    };

    private Color[][] well;
    private ArrayList<Integer> tetraminos = new ArrayList<>();
    private Color pieceColor;
    private int[] piece;
    private int pieceX, pieceY;
    private long score;
    private int queueIndex;

    private void initGame() {
        well = new Color[BOARD_WIDTH][BOARD_HEIGHT];
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                well[i][j] = Color.BLACK;
            }
        }
        spawnNewPiece();
        score = 0;
        queueIndex = 0;
    }

    private void spawnNewPiece() {
        pieceX = 5;
        pieceY = 0;
        if (tetraminos.isEmpty()) {
            for (int i = 0; i < 7; i++) tetraminos.add(i);
            Collections.shuffle(tetraminos);
        }
        int type = tetraminos.remove(0);
        pieceColor = colors[type];
        piece = getShape(type);
    }

    private int[] getShape(int type) {
        switch (type) {
            case 0: return new int[]{1, 1, 1, 1}; // I
            case 1: return new int[]{1, 0, 0, 1, 1, 1, 0, 0, 0}; // J
            case 2: return new int[]{0, 0, 1, 1, 1, 1, 0, 0, 0}; // L
            case 3: return new int[]{1, 1, 1, 1}; // O (simplified 2x2 or 4x1 representation)
            case 4: return new int[]{0, 1, 1, 1, 1, 0, 0, 0, 0}; // S
            case 5: return new int[]{0, 1, 0, 1, 1, 1, 0, 0, 0}; // T
            case 6: return new int[]{1, 1, 0, 0, 1, 1, 0, 0, 0}; // Z
        }
        return new int[]{1, 1, 1, 1};
    }

    private boolean collides(int x, int y, int[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 0) continue;
            int px = x + (i % 3) - 1;
            int py = y + (i / 3);
            if (px < 0 || px >= BOARD_WIDTH || py >= BOARD_HEIGHT) return true;
            if (py >= 0 && well[px][py] != Color.BLACK) return true;
        }
        return false;
    }

    private void fixToWell() {
        for (int i = 0; i < piece.length; i++) {
            if (piece[i] == 0) continue;
            int px = pieceX + (i % 3) - 1;
            int py = pieceY + (i / 3);
            if (py >= 0 && py < BOARD_HEIGHT && px >= 0 && px < BOARD_WIDTH) {
                well[px][py] = pieceColor;
            }
        }
        clearRows();
        spawnNewPiece();
        if (collides(pieceX, pieceY, piece)) {
            initGame(); // Reset on game over
        }
    }

    private void clearRows() {
        int cleared = 0;
        for (int y = BOARD_HEIGHT - 1; y >= 0; y--) {
            boolean full = true;
            for (int x = 0; x < BOARD_WIDTH; x++) {
                if (well[x][y] == Color.BLACK) {
                    full = false;
                    break;
                }
            }
            if (full) {
                for (int ty = y; ty > 0; ty--) {
                    for (int tx = 0; tx < BOARD_WIDTH; tx++) {
                        well[tx][ty] = well[tx][ty - 1];
                    }
                }
                for (int tx = 0; tx < BOARD_WIDTH; tx++) {
                    well[tx][0] = Color.BLACK;
                }
                y0Check(y);
                cleared++;
            }
        }
        if (cleared > 0) {
            score += cleared * 100 * cleared;
        }
    }

    private void y0Check(int y) {
        // Helper to keep loop aligned after shift
    }

    private void rotate() {
        int[] rotated = new int[piece.length];
        int n = (piece.length == 4) ? 2 : 3;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                rotated[c * n + (n - 1 - r)] = piece[r * n + c];
            }
        }
        if (!collides(pieceX, pieceY, rotated)) {
            piece = rotated;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int blockSize = 25;

        // Draw well
        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_HEIGHT; y++) {
                g.setColor(well[x][y]);
                g.fillRect(x * blockSize, y * blockSize, blockSize - 1, blockSize - 1);
            }
        }

        // Draw current piece
        g.setColor(pieceColor);
        int n = (piece.length == 4) ? 2 : 3;
        for (int i = 0; i < piece.length; i++) {
            if (piece[i] == 0) continue;
            int px = pieceX + (i % n) - 1;
            int py = pieceY + (i / n);
            if (py >= 0) {
                g.fillRect(px * blockSize, py * blockSize, blockSize - 1, blockSize - 1);
            }
        }

        // Draw score
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
    }

    public Tetris() {
        initGame();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (!collides(pieceX - 1, pieceY, piece)) pieceX--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (!collides(pieceX + 1, pieceY, piece)) pieceX++;
                        break;
                    case KeyEvent.VK_DOWN:
                        if (!collides(pieceX, pieceY + 1, piece)) pieceY++;
                        else fixToWell();
                        break;
                    case KeyEvent.VK_UP:
                        rotate();
                        break;
                    case KeyEvent.VK_SPACE:
                        while (!collides(pieceX, pieceY + 1, piece)) pieceY++;
                        fixToWell();
                        break;
                }
                repaint();
            }
        });
        setFocusable(true);

        // Timer for falling blocks
        new Timer(400, e -> {
            if (!collides(pieceX, pieceY + 1, piece)) {
                pieceY++;
            } else {
                fixToWell();
            }
            repaint();
        }).start();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Java Tetris");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(320, 640);
        f.add(new Tetris());
        f.setVisible(true);
    }
}

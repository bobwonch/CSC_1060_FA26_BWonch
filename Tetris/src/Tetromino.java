import java.awt.Color;

public class Tetromino {
    private static final Color[] COLORS = {
        Color.decode("#0effff"), Color.decode("#0000ff"), Color.decode("#ffaa00"),
        Color.decode("#ffff00"), Color.decode("#00ff00"), Color.decode("#aa00aa"),
        Color.decode("#ff0000")
    };

    private int[] shape;
    private Color color;
    private int x;
    private int y;
    private final int type;

    public Tetromino(int type) {
        this.type = type;
        this.color = COLORS[type];
        this.shape = initShape(type);
        // Start closer to the center since the I-piece is now 4 spaces wide
        this.x = (type == 0) ? 4 : 5; 
        this.y = 0;
    }

    private int[] initShape(int type) {
        switch (type) {
            // I-Piece (Type 0): 4x4 matrix (16 elements), flat row on the second row
            case 0: return new int[]{
                0, 0, 0, 0,
                1, 1, 1, 1,
                0, 0, 0, 0,
                0, 0, 0, 0
            }; 
            case 1: return new int[]{1, 0, 0, 1, 1, 1, 0, 0, 0}; // J (3x3)
            case 2: return new int[]{0, 0, 1, 1, 1, 1, 0, 0, 0}; // L (3x3)
            // O-Piece (Type 3): 2x2 matrix (4 elements)
            case 3: return new int[]{1, 1, 1, 1}; 
            case 4: return new int[]{0, 1, 1, 1, 1, 0, 0, 0, 0}; // S (3x3)
            case 5: return new int[]{0, 1, 0, 1, 1, 1, 0, 0, 0}; // T (3x3)
            case 6: return new int[]{1, 1, 0, 0, 1, 1, 0, 0, 0}; // Z (3x3)
            default: return new int[]{1, 1, 1, 1};
        }
    }

    public int[] getShape() { return shape; }
    public Color getColor() { return color; }
    public int getX() { return x; }
    public int getY() { return y; }
    
    // Corrected to handle 4x4 (16), 2x2 (4), and 3x3 (9) matrices properly
    public int getMatrixSize() { 
        if (shape.length == 16) return 4;
        if (shape.length == 4) return 2;
        return 3;
    }

    public void moveLeft() { x--; }
    public void moveRight() { x++; }
    public void moveDown() { y++; }

    public int[] getRotatedShape() {
        // The O-piece doesn't need to rotate
        if (type == 3) return shape; 

        int[] rotated = new int[shape.length];
        int n = getMatrixSize();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                rotated[c * n + (n - 1 - r)] = shape[r * n + c];
            }
        }
        return rotated;
    }

    public void setShape(int[] newShape) {
        this.shape = newShape;
    }
}

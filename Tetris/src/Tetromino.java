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
        this.x = 5;
        this.y = 0;
    }

    private int[] initShape(int type) {
        switch (type) {
            case 0: return new int[]{1, 1, 1, 1}; // I
            case 1: return new int[]{1, 0, 0, 1, 1, 1, 0, 0, 0}; // J
            case 2: return new int[]{0, 0, 1, 1, 1, 1, 0, 0, 0}; // L
            case 3: return new int[]{1, 1, 1, 1}; // O
            case 4: return new int[]{0, 1, 1, 1, 1, 0, 0, 0, 0}; // S
            case 5: return new int[]{0, 1, 0, 1, 1, 1, 0, 0, 0}; // T
            case 6: return new int[]{1, 1, 0, 0, 1, 1, 0, 0, 0}; // Z
            default: return new int[]{1, 1, 1, 1};
        }
    }

    public int[] getShape() { return shape; }
    public Color getColor() { return color; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getMatrixSize() { return (shape.length == 4) ? 2 : 3; }

    public void moveLeft() { x--; }
    public void moveRight() { x++; }
    public void moveDown() { y++; }

    public int[] getRotatedShape() {
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

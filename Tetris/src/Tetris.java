import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tetris extends JPanel {
    private static final int BLOCK_SIZE = 25;
    private final Board board;
    private Tetromino currentPiece;
    private boolean showGrid = true; // Add this line right below currentPiece
    private boolean isPaused = false;
    
    public Tetris() {
        board = new Board();
        initGame();
        
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setBackground(Color.WHITE); // Keeps the padding area seamless with your layout

        this.setPreferredSize(new Dimension(600, Board.HEIGHT * BLOCK_SIZE + 10));
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            	// Allow the P key to toggle pause at any time
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    isPaused = !isPaused;
                    repaint();
                    return;
                }

                // If the game is paused, ignore all other movement controls
                if (isPaused) return;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (!board.collides(currentPiece.getX() - 1, currentPiece.getY(), currentPiece.getShape(), currentPiece.getMatrixSize())) {
                            currentPiece.moveLeft();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (!board.collides(currentPiece.getX() + 1, currentPiece.getY(), currentPiece.getShape(), currentPiece.getMatrixSize())) {
                            currentPiece.moveRight();
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        advanceGameStep();
                        break;
                    case KeyEvent.VK_UP:
                        rotatePiece();
                        break;
                    case KeyEvent.VK_SPACE:
                        while (!board.collides(currentPiece.getX(), currentPiece.getY() + 1, currentPiece.getShape(), currentPiece.getMatrixSize())) {
                            currentPiece.moveDown();
                        }
                        lockAndNext();
                        break;
                    case KeyEvent.VK_G: // ─── ADD THIS CASE ───
                        showGrid = !showGrid;
                        break;
                    
                }
                repaint();
            }
        });
        setFocusable(true);
        
        new Timer(400, e -> {
            if (!isPaused) { // ─── WRAP THIS LOGIC ───
                advanceGameStep();
                repaint();
            }
        }).start();
    }

    private void initGame() {
        board.initBoard();
        currentPiece = board.spawnNextPiece();
    }

    private void rotatePiece() {
        int[] rotated = currentPiece.getRotatedShape();
        if (!board.collides(currentPiece.getX(), currentPiece.getY(), rotated, currentPiece.getMatrixSize())) {
            currentPiece.setShape(rotated);
        }
    }

    private void advanceGameStep() {
        if (!board.collides(currentPiece.getX(), currentPiece.getY() + 1, currentPiece.getShape(), currentPiece.getMatrixSize())) {
            currentPiece.moveDown();
        } else {
            lockAndNext();
        }
    }

    private void lockAndNext() {
        board.fixToWell(currentPiece);
        currentPiece = board.spawnNextPiece();
        // Check game over
        if (board.collides(currentPiece.getX(), currentPiece.getY(), currentPiece.getShape(), currentPiece.getMatrixSize())) {
            initGame();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerXOffset = 150; 
        int gridLineOffset = 1; 

        // 1. Paint background well matrix grid
        Color[][] well = board.getWell();
        for (int x = 0; x < Board.WIDTH; x++) {
            for (int y = 0; y < Board.HEIGHT; y++) {
                g.setColor(well[x][y]);
                int renderX = (x * BLOCK_SIZE) + gridLineOffset + centerXOffset;
                int renderY = (y * BLOCK_SIZE) + gridLineOffset;
                if(showGrid) {
                	g.fillRect(renderX, renderY, BLOCK_SIZE - 1, BLOCK_SIZE - 1);
                }else {
                    // Fills the entire block space to close the gaps
                    g.fillRect(renderX - 1, renderY - 1, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        // 2. Paint active falling piece blocks
        g.setColor(currentPiece.getColor());
        int[] shape = currentPiece.getShape();
        int n = currentPiece.getMatrixSize();
        for (int i = 0; i < shape.length; i++) {
            if (shape[i] == 0) continue;
            int px = currentPiece.getX() + (i % n) - 1;
            int py = currentPiece.getY() + (i / n);
            if (py >= 0) {
                int renderX = (px * BLOCK_SIZE) + gridLineOffset + centerXOffset;
                int renderY = (py * BLOCK_SIZE) + gridLineOffset;
                g.fillRect(renderX, renderY, BLOCK_SIZE - 1, BLOCK_SIZE - 1);
            }
        }

        // 3. Paint game HUD status info (Left Margin)
        g.setColor(Color.WHITE);
        g.drawString("Score: " + board.getScore(), 40, 30);

        // ─── 4. NEW: DRAW THE NEXT PIECE PREVIEW BOX (Right Margin) ───
        int previewBoxX = 470;
        int previewBoxY = 30;
        int previewBoxSize = 100;

        // Draw the box boundary framing
        g.setColor(Color.DARK_GRAY);
        g.drawRect(previewBoxX, previewBoxY, previewBoxSize, previewBoxSize);
        g.setColor(Color.WHITE);
        g.drawString("NEXT", previewBoxX + 32, previewBoxY - 8);

        // Grab the next piece from the board data model
        Tetromino nextPiece = board.getNextPiece();
        if (nextPiece != null) {
            g.setColor(nextPiece.getColor());
            int[] nextShape = nextPiece.getShape();
            int nextN = nextPiece.getMatrixSize();
            
            // Dynamic centering variables to keep different block types looking neat in the box
            int blockPaddingOffset = (nextN == 2) ? 25 : 12;

            for (int i = 0; i < nextShape.length; i++) {
                if (nextShape[i] == 0) continue;
                
                // Map grid coordinates locally inside the 100x100 box boundary
                int bx = (i % nextN) * BLOCK_SIZE + previewBoxX + blockPaddingOffset;
                int by = (i / nextN) * BLOCK_SIZE + previewBoxY + 25;
                
                g.fillRect(bx, by, BLOCK_SIZE - 1, BLOCK_SIZE - 1);
            }
        }
        if (isPaused) {
            g.setColor(new Color(0, 0, 0, 150)); // Semi-transparent dark background overlay
            g.fillRect(0, 0, getWidth(), getHeight());
            
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("PAUSED", getWidth() / 2 - 60, getHeight() / 2);
        }
    }



    public static void main(String[] args) {
        JFrame f = new JFrame("Java Tetris");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Tetris game = new Tetris();
        f.add(game);
        
        f.pack(); // DO NOT use f.setSize(320, 640) anywhere here, let pack load the 600px width!
        f.setLocationRelativeTo(null); 
        f.setVisible(true);
    }

}

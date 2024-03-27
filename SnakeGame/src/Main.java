import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class SnakeGame extends JPanel implements ActionListener, KeyListener {
    private ArrayList<Point> snake;
    private Point food;
    private char direction;
    private Timer timer;
    private final int gridSize = 20;
    private final int numColumns = 25; // Based on 500/20
    private final int numRows = 25;    // Based on 500/20

    public SnakeGame(int width, int height) {
        snake = new ArrayList<>();
        snake.add(new Point(5, 5));
        spawnFood();
        direction = 'R';
        timer = new Timer(100, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
    }

    private void spawnFood() {
        do {
            food = new Point((int) (Math.random() * numColumns), (int) (Math.random() * numRows));
        } while (snake.contains(food));
    }

    public void actionPerformed(ActionEvent e) {
        move();
        checkCollision();
        checkFood();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSnake(g);
        drawFood(g);
    }

    public void drawSnake(Graphics g) {
        for (Point p : snake) {
            g.setColor(Color.GREEN);
            g.fillRect(p.x * gridSize, p.y * gridSize, gridSize, gridSize);
        }
    }

    public void drawFood(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(food.x * gridSize, food.y * gridSize, gridSize, gridSize);
    }

    public void move() {
        Point head = (Point) snake.get(0).clone(); // Clone to avoid direct modification

        switch (direction) {
            case 'U': head.translate(0, -1); break;
            case 'D': head.translate(0, 1); break;
            case 'L': head.translate(-1, 0); break;
            case 'R': head.translate(1, 0); break;
        }

        snake.add(0, head);
        if (!head.equals(food)) { // Only remove the tail if not eating
            snake.remove(snake.size() - 1);
        }
    }

    public void checkCollision() {
        Point head = snake.get(0);

        // Check collision with walls
        if (head.x < 0 || head.x >= numColumns || head.y < 0 || head.y >= numRows) {
            gameOver();
        }

        // Check self-collision
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                gameOver();
            }
        }
    }

    public void checkFood() {
        Point head = snake.get(0);
        if (head.equals(food)) {
            spawnFood();
        }
    }

    public void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                if (direction != 'R') direction = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') direction = 'R';
                break;
            case KeyEvent.VK_UP:
                if (direction != 'D') direction = 'U';
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') direction = 'D';
                break;
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame snakeGame = new SnakeGame(500, 500);
        frame.add(snakeGame);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

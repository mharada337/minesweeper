import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Main extends JPanel implements MouseListener {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 360;
    public static final int FPS = 60;
    World world;

    class Runner implements Runnable {
        public void run() {
            while(true){
                    repaint();
                try {
                    Thread.sleep(1000/FPS);
                }
                catch(InterruptedException e){}
            }
        
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
        world.reveal(e.getX(), e.getY());
    }    

    public Main() {
        world = new World();
        addMouseListener(this);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        Thread mainThread = new Thread(new Runner());
        mainThread.start();
    }

    public static void main(String[] args) {
       JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main mainInstance = new Main();
        frame.setContentPane(mainInstance);

        frame.pack();
        frame.setVisible(true);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
     
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        world.drawWorld(g);
    }
}
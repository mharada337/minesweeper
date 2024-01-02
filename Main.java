import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

public class Main extends JPanel {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
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

    public Main() {
        world = new World();
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
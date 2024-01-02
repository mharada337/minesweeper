import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.util.ArrayList;

public class World {
    private static int width = 30;
    private static int height = 16;
    private static boolean[] revealed = new boolean[width*height];
    private static int[][] ground = new int[height][width];
    private BufferedImage tile;
    private BufferedImage marker1;
    private BufferedImage marker2;
    private BufferedImage marker3;
    private BufferedImage marker4;
    private BufferedImage marker5;
    private BufferedImage marker6;
    private BufferedImage marker7;
    private BufferedImage marker8;
    private BufferedImage clear;
    private BufferedImage flag;
    private BufferedImage mine;

    public World() {
        setMines(ground);
        setMarkers(ground);

        for(int i = 0; i < revealed.length; i++) {
            revealed[i] = false;
        }

        try {
            tile = ImageIO.read(new File("images/tile.png"));
            marker1 = ImageIO.read(new File("images/marker_1.png"));
            marker2 = ImageIO.read(new File("images/marker_2.png"));
            marker3 = ImageIO.read(new File("images/marker_3.png"));
            marker4 = ImageIO.read(new File("images/marker_4.png"));
            marker5 = ImageIO.read(new File("images/marker_5.png"));
            marker6 = ImageIO.read(new File("images/marker_6.png"));
            marker7 = ImageIO.read(new File("images/marker_7.png"));
            marker8 = ImageIO.read(new File("images/marker_8.png"));
            clear = ImageIO.read(new File("images/uncovered.png"));
            flag = ImageIO.read(new File("images/flag.png"));
            mine = ImageIO.read(new File("images/mine.png"));

        }
        catch (IOException ex) {
            System.out.println("Failed to find image.");
        }
    }

    public static void setMines(int[][] ground) {
        ArrayList<Integer> locations = new ArrayList<Integer>();
        for(int i = 0; i < width * height; i++) {
            locations.add(i);
        }
        for(int mines = 0; mines < 99; mines++) {
            int rand = (int)(Math.random() * (width * height - mines));
            int mineX = locations.get(rand) % width;
            int mineY = locations.get(rand)/width;
            ground[mineY][mineX] = 9;
            locations.remove(rand);
        }
    }

    public static void setMarkers(int[][] ground) {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(ground[y][x] == 9) {
                    if(y == 0) {
                        if(x == 0) {
                            checkMine(ground, y + 1, x);
                            checkMine(ground, y, x + 1);
                            checkMine(ground, y + 1, x + 1);
                        }
                        else if(x == width - 1) {
                            checkMine(ground, y + 1, x);
                            checkMine(ground, y, x - 1);
                            checkMine(ground, y + 1, x - 1);
                        }
                        else {
                            checkMine(ground, y + 1, x);
                            checkMine(ground, y + 1, x - 1);
                            checkMine(ground, y + 1, x + 1);
                            checkMine(ground, y, x - 1);
                            checkMine(ground, y, x + 1);
                        }
                    }
                    else if(y == height - 1) {
                        if(x == 0) {
                            checkMine(ground, y - 1, x);
                            checkMine(ground, y - 1, x + 1);
                            checkMine(ground, y, x + 1);
                        }
                        else if(x == width - 1) {
                            checkMine(ground, y - 1, x);
                            checkMine(ground, y - 1, x - 1);
                            checkMine(ground, y, x - 1);
                        }
                        else { 
                            checkMine(ground, y - 1, x);
                            checkMine(ground, y - 1, x - 1);
                            checkMine(ground, y - 1, x + 1);
                            checkMine(ground, y, x - 1);
                            checkMine(ground, y, x + 1);
                        }
                    }
                    else if(x == 0) {
                        checkMine(ground, y - 1, x);
                        checkMine(ground, y - 1, x + 1);
                        checkMine(ground, y, x + 1);
                        checkMine(ground, y + 1, x);
                        checkMine(ground, y + 1, x + 1);
                    }
                    else if(x == width - 1) {
                        checkMine(ground, y - 1, x - 1);
                        checkMine(ground, y - 1, x);
                        checkMine(ground, y, x - 1);
                        checkMine(ground, y + 1, x - 1);
                        checkMine(ground, y + 1, x);
                    }
                    else {
                        checkMine(ground, y - 1, x - 1);
                        checkMine(ground, y - 1, x);
                        checkMine(ground, y - 1, x + 1);
                        checkMine(ground, y, x - 1);
                        checkMine(ground, y, x + 1);
                        checkMine(ground, y + 1, x - 1);
                        checkMine(ground, y + 1, x);
                        checkMine(ground, y + 1, x + 1);
                    }
                }
            }
        }
    }

    public static void checkMine(int[][] ground, int y, int x) {
        if(ground[y][x] != 9) {
            ground[y][x]++;
        }
    }

    public void reveal(int userX, int userY) {
        int pointX = (userX - 20)/20;
        int pointY = (userY - 20)/20;
        int revealedArrayIndex = pointY * width + pointX;
        revealed[revealedArrayIndex] = true;
    }

    public void drawWorld(Graphics g) {
        for(int y = 1; y < height + 1; y++) {
            for(int x = 1; x < width + 1; x++) {
                if(revealed[(y - 1) * width + (x - 1)] == false) {
                    g.drawImage(tile, x * 20, y * 20, null);
                }
                else {
                    if(ground[y - 1][x - 1] == 0) {
                        g.drawImage(clear, 20 * x, 20 * y, null);
                    }
                    if(ground[y - 1][x - 1] == 1) {
                        g.drawImage(marker1, 20 * x, 20 * y, null);
                    }
                    if(ground[y - 1][x - 1] == 2) {
                        g.drawImage(marker2, 20 * x, 20 * y, null);
                    }
                    if(ground[y - 1][x - 1] == 3) {
                        g.drawImage(marker3, 20 * x, 20 * y, null);
                    }
                    if(ground[y - 1][x - 1] == 4) {
                        g.drawImage(marker4, 20 * x, 20 * y, null);
                    }
                    if(ground[y - 1][x - 1] == 5) {
                        g.drawImage(marker5, 20 * x, 20 * y, null);
                    }
                    if(ground[y - 1][x - 1] == 6) {
                        g.drawImage(marker6, 20 * x, 20 * y, null);
                    }
                    if(ground[y - 1][x - 1] == 7) {
                        g.drawImage(marker7, 20 * x, 20 * y, null);
                    }
                    if(ground[y - 1][x - 1] == 8) {
                        g.drawImage(marker8, 20 * x, 20 * y, null);
                    }
                    if(ground[y - 1][x - 1] == 9) {
                        g.drawImage(mine, 20 * x, 20 * y, null);
                    }
                }
            }
        }
    }
}

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;

public class World {
    public static int[][] ground = new int[10][10];
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
        int mines = 0;
        while(mines < 10) {
            int x = (int)(Math.random() * 9);
            int y = (int)(Math.random() * 9);
            
            if(ground[x][y] != 9) {
                ground[x][y] = 9;
                mines++;
            }
        }
    }

    public static void setMarkers(int[][] ground) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(ground[i][j] == 9) {
                    if(i == 0) {
                        if(j == 0) {
                            checkMine(ground, i + 1, j);
                            checkMine(ground, i, j + 1);
                            checkMine(ground, i + 1, j + 1);
                        }
                        else if(j == 8) {
                            checkMine(ground, i + 1, j);
                            checkMine(ground, i, j - 1);
                            checkMine(ground, i + 1, j - 1);
                        }
                        else {
                            checkMine(ground, i + 1, j);
                            checkMine(ground, i + 1, j - 1);
                            checkMine(ground, i + 1, j + 1);
                            checkMine(ground, i, j - 1);
                            checkMine(ground, i, j + 1);
                        }
                    }
                    else if(i == 8) {
                        if(j == 0) {
                            checkMine(ground, i - 1, j);
                            checkMine(ground, i - 1, j + 1);
                            checkMine(ground, i, j + 1);
                        }
                        else if(j == 8) {
                            checkMine(ground, i - 1, j);
                            checkMine(ground, i - 1, j - 1);
                            checkMine(ground, i, j - 1);
                        }
                        else { 
                            checkMine(ground, i - 1, j);
                            checkMine(ground, i - 1, j - 1);
                            checkMine(ground, i - 1, j + 1);
                            checkMine(ground, i, j - 1);
                            checkMine(ground, i, j + 1);
                        }
                    }
                    else if(j == 0) {
                        checkMine(ground, i - 1, j);
                        checkMine(ground, i - 1, j + 1);
                        checkMine(ground, i, j + 1);
                        checkMine(ground, i + 1, j);
                        checkMine(ground, i + 1, j + 1);
                    }
                    else if(j == 8) {
                        checkMine(ground, i - 1, j - 1);
                        checkMine(ground, i - 1, j);
                        checkMine(ground, i, j - 1);
                        checkMine(ground, i + 1, j - 1);
                        checkMine(ground, i + 1, j);
                    }
                    else {
                        checkMine(ground, i - 1, j - 1);
                        checkMine(ground, i - 1, j);
                        checkMine(ground, i - 1, j + 1);
                        checkMine(ground, i, j - 1);
                        checkMine(ground, i, j + 1);
                        checkMine(ground, i + 1, j - 1);
                        checkMine(ground, i + 1, j);
                        checkMine(ground, i + 1, j + 1);
                    }
                }
            }
        }
    }

    public static void checkMine(int[][] ground, int i, int j) {
        if(ground[i][j] != 9) {
            ground[i][j]++;
        }
    }

    public void drawWorld(Graphics g) {
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                if(ground[i - 1][j - 1] == 0) {
                    g.drawImage(clear, 20 * i, 20 * j, null);
                }
                if(ground[i - 1][j - 1] == 1) {
                    g.drawImage(marker1, 20 * i, 20 * j, null);
                }
                if(ground[i - 1][j - 1] == 2) {
                    g.drawImage(marker2, 20 * i, 20 * j, null);
                }
                if(ground[i - 1][j - 1] == 3) {
                    g.drawImage(marker3, 20 * i, 20 * j, null);
                }
                if(ground[i - 1][j - 1] == 4) {
                    g.drawImage(marker4, 20 * i, 20 * j, null);
                }
                if(ground[i - 1][j - 1] == 5) {
                    g.drawImage(marker5, 20 * i, 20 * j, null);
                }
                if(ground[i - 1][j - 1] == 6) {
                    g.drawImage(marker6, 20 * i, 20 * j, null);
                }
                if(ground[i - 1][j - 1] == 7) {
                    g.drawImage(marker7, 20 * i, 20 * j, null);
                }
                if(ground[i - 1][j - 1] == 8) {
                    g.drawImage(marker8, 20 * i, 20 * j, null);
                }
                if(ground[i - 1][j - 1] == 9) {
                    g.drawImage(mine, i * 20, j * 20, null);
                }
            }
        }
    }

}

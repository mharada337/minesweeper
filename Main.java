public class Main {

    public static int[][] ground = new int[10][10];

    public static void main(String[] args) {

        setMines(ground);
        setMarkers(ground);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(ground[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void setMines(int[][] ground) {

        for(int mines = 0; mines < 10; mines++) {
            int x = (int)(Math.random() * 9);
            int y = (int)(Math.random() * 9);
            ground[x][y] = 9;
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

}
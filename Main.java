public class Main {

    public static int[][] ground = new int[10][10];

    public static void main(String[] args) {

        setMines(ground);
        setMarkers(ground);

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(ground[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void setMines(int[][] ground) {

        for(int mines = 0; mines < 10; mines++) {
            int x = (int)(Math.random() * 8) + 1;
            int y = (int)(Math.random() * 8) + 1;
            ground[x][y] = 9;
        }

    }

    public static void setMarkers(int[][] ground) {
        for(int i = 0; i < 10; i++) {
        }
    }

}
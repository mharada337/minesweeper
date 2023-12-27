public class Main {
    public static void main(String[] args) {
        int[][] ground = new int[9][9];
        for(int flags = 0; flags < 10; flags++) {
            int x = (int)(Math.random() * 9);
            int y = (int)(Math.random() * 9);
            ground[x][y] = 9;
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                //trial
                // if((i == 0) && (ground[i][j] == 9)) {
                //     ground[i][j - 1]++;
                //     ground[i][j + 1]++;
                // }

                // if(ground[i][j] == 9) {
                //     if((i - 1 >= 0) && (j != 8) && (j != 0)) {
                //         ground[i - 1][j - 1]++;
                //         ground[i - 1][j]++;
                //         ground[i - 1][j + 1]++;
                //     }
                //     if((j != 8) && (j != 0)) {
                //         ground[i][j - 1]++;
                //         ground[i][j + 1]++;
                //     }
                //     if((i + 1 < 9) && (j != 8) && (j != 0)) {
                //         ground[i + 1][j - 1]++;
                //         ground[i + 1][j]++;
                //         ground[i + 1][j + 1]++;
                //     }
                // }
                System.out.print(ground[i][j] + " ");
            }
            System.out.println();
        }

    }
}
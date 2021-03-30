
public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] cells = new int[m][n];

        int bomb = k;
        while (bomb > 0) {
            // int row = (int) (Math.random() * m);
            // int col = (int) (Math.random() * n);

            int rand = (int) (Math.random()*n*m);
            int row = rand/n;
            int col = rand - n*row;
            if (cells[row][col] == 0) {
                cells[row][col] = Integer.MIN_VALUE;
                bomb--;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j] < 0) {
                    if (i > 0) {
                        cells[i - 1][j]++;
                        if (j > 0) {
                            cells[i - 1][j - 1]++;
                        }
                        if (j < n - 1) {
                            cells[i - 1][j + 1]++;
                        }
                    }
                    if (i < m - 1) {
                        cells[i + 1][j]++;
                        if (j > 0) {
                            cells[i + 1][j - 1]++;
                        }
                        if (j < n - 1) {
                            cells[i + 1][j + 1]++;
                        }
                    }
                    if (j > 0) {
                        cells[i][j - 1]++;
                    }

                    if (j < n - 1) {
                        cells[i][j + 1]++;
                    }

                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j] < 0) {
                    System.out.print('*');
                } else {
                    System.out.print(cells[i][j]);
                }
                System.out.print(j == n - 1 ? '\n' : "  ");
            }
        }
    }
}

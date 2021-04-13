
public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguos square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a[0].length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {

                }
            }
        }
        return maxLength;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = StdIn.readInt();
            }
        }
        int size = size(arr);
        StdOut.println(size);
    }
}

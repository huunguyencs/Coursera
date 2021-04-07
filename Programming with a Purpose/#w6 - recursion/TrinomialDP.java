
public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < -n || k > n) {
            return 0;
        }
        long[][] coeff = new long[n + 1][];
        coeff[0] = new long[] { 1 };
        for (int i = 1; i <= n; i++) {
            coeff[i] = new long[2 * i + 1];
            for (int j = 0; j < 2 * i + 1; j++) {
                long a, b, c;
                if (j == 0 || j == 1) {
                    a = 0;
                } else {
                    a = coeff[i - 1][j - 2];
                }
                if (j == 2 * i - 1 || j == 2 * i) {
                    c = 0;
                } else {
                    c = coeff[i - 1][j];
                }
                if (j == 0 || j == 2 * i) {
                    b = 0;
                } else {
                    b = coeff[i - 1][j - 1];
                }
                coeff[i][j] = a + b + c;

            }
        }
        return coeff[n][n + k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long t = trinomial(n, k);
        System.out.println(t);
    }
}



public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(args[i + 1]);
        }

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + input[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * sum[n]);
            int j = 1;
            while (r > sum[j]) {
                j++;
            }
            System.out.print(j);
            System.out.print(i == m - 1 ? '\n' : ' ');
        }
    }
}

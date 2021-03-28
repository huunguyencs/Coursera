
public class ShannonEntropy {
    public static void main(String[] args) {
        if (args.length <= 0)
            return;
        int m = Integer.parseInt(args[0]);
        int[] arr = new int[m + 1];
        int n = 0;

        while (!StdIn.isEmpty()) {
            int tmp = StdIn.readInt();
            arr[tmp]++;
            n++;
        }

        double entropy = 0.0;

        for (int i = 1; i <= m; i++) {
            double p = arr[i] * 1.0 / n;
            if (p > 0.0)
                entropy += -p * Math.log(p) / Math.log(2);
        }
        StdOut.printf("%.4f\n", entropy);
    }
}

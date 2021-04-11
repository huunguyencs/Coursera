
public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int n = a.length;
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] arr = new int[n];
        long cnt = k;
        for (int i = 0; i < n; i++) {
            if (cnt > n - i - 1) {
                arr[i] = n - i - 1;
                cnt -= n - i - 1;
            } else {
                arr[n - (int) cnt - 1] = n - i - 1;
                break;
            }
            if (cnt <= 0) {
                break;
            }
        }
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = tmp;
                tmp++;
            }
        }
        return arr;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactlyk inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] r = generate(n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(r[i] + " ");
        }
        System.out.println();
    }
}

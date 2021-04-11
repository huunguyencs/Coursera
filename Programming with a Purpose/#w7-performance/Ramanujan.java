
public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        boolean first = false;
        long firstNum = -1;
        for (long i = 1; i < Math.cbrt(n); i++) {
            double cube = n - i * i * i;
            long a = Math.round(Math.cbrt(cube));
            if (cube == a * a * a && a != i) {
                if (first && firstNum != i) {
                    return true;
                } else {
                    first = true;
                    firstNum = a;
                }
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}

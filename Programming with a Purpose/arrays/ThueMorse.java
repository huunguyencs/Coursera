
public class ThueMorse {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int bita = Integer.bitCount(i) % 2;
                int bitb = Integer.bitCount(j) % 2;
                boolean c = bita == bitb;
                if (c) {
                    System.out.print("+");
                } else {
                    System.out.print("-");
                }
                System.out.print(j == n - 1 ? '\n' : "  ");
            }
        }
    }

}


public class RevesPuzzle {

    private static void hanoiTower(int n, int k, String src, String tmp, String des) {
        if (n == 1) {
            System.out.println("Move disc " + (k + 1) + " from " + src + " to " + des);
            return;
        }
        hanoiTower(n - 1, k, src, des, tmp);
        System.out.println("Move disc " + (n + k) + " from " + src + " to " + des);
        hanoiTower(n - 1, k, tmp, src, des);
    }

    private static void puzzle(int n, String src, String tmp1, String tmp2, String des) {
        if (n == 1) {
            System.out.println("Move disc 1 from " + src + " to " + des);
            return;
        }
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        // System.out.println(k);
        puzzle(k, src, tmp2, des, tmp1);
        hanoiTower(n - k, k, src, tmp2, des);
        puzzle(k, tmp1, src, tmp2, des);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // hanoiTower(n, "A", "B", "C");
        puzzle(n, "A", "B", "C", "D");
    }
}

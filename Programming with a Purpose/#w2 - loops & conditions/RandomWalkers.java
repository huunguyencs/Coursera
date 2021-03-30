
public class RandomWalkers {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double res = 0;
        for (int i = 0; i < trials; i++) {
            int x = 0, y = 0;
            int count = 0;
            boolean isDes = r == 0;
            while (!isDes) {
                int rand = (int) (Math.random() * 4);
                switch (rand) {
                case 0:
                    x++;
                    break;
                case 1:
                    x--;
                    break;
                case 2:
                    y++;
                    break;
                default:
                    y--;
                    break;
                }
                count++;
                isDes = (Math.abs(x) + Math.abs(y)) == r;
            }
            res += count;
        }
        res = res / trials;
        System.out.println("average number of steps = " + res);
    }
}

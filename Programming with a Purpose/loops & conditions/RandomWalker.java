
public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0, y = 0;
        System.out.println("(" + x + ", " + y + ")");
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
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + count);
    }
}

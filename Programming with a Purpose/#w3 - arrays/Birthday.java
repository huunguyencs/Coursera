
public class Birthday {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] numPerDay = new int[n];
        for (int i = 0; i < trials; i++) {
            boolean[] day = new boolean[n];
            int dayTh = 0;
            while (dayTh < n) {
                int r = (int) (Math.random() * (n - 1));
                if (day[r]) {
                    numPerDay[dayTh]++;
                } else {
                    day[r] = true;
                }
                dayTh++;
            }
        }

        double frac = 0.0;
        int i = 0;
        while (i < n && frac < 0.5) {
            frac += 1.0 * numPerDay[i] / trials;
            i++;
            System.out.println(i + "\t" + numPerDay[i - 1] + "\t" + frac);
        }
    }
}
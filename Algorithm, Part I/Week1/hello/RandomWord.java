// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int i = 1;
        String champion = "";
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            boolean isChoose = StdRandom.bernoulli(1.0 / i);
            champion = isChoose ? word : champion;
            i++;
        }
        StdOut.println(champion);
    }
}

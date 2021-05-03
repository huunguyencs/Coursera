
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> stringQueue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String tmp = StdIn.readString();
            stringQueue.enqueue(tmp);
        }

        for (int i = 0; i < k; i++) {
            String tmp = stringQueue.dequeue();
            StdOut.println(tmp);
        }
    }
}

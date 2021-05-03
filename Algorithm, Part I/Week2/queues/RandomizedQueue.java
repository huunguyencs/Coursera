import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size;

    // contruct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue.
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == queue.length)
            resize(2 * size);
        queue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int random = size > 1 ? StdRandom.uniform(0, size) : 0;
        Item item = queue[random];
        size--;
        for (int i = random; i < size; i++) {
            queue[i] = queue[i + 1];
        }
        queue[size] = null;
        if (size > 0 && size == queue.length / 4)
            resize(queue.length / 2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int random = size > 1 ? StdRandom.uniform(0, size) : 0;
        return queue[random];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizeQueueIterator();
    }

    // resize the queue
    private void resize(int newSize) {
        Item[] newQueue = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }

    private class RandomizeQueueIterator implements Iterator<Item> {
        RandomizedQueue<Item> temp;

        RandomizeQueueIterator() {
            temp = new RandomizedQueue<Item>();
            for (int i = 0; i < size; i++) {
                temp.enqueue(queue[i]);
            }
        }

        public boolean hasNext() {
            return temp.size() > 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return temp.dequeue();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rQueue = new RandomizedQueue<Integer>();
        rQueue.enqueue(5);
        rQueue.enqueue(7);
        rQueue.enqueue(12);
        rQueue.enqueue(1);
        rQueue.dequeue();
        Integer x = rQueue.sample();

        for (Integer item : rQueue) {
            System.out.println(item);
        }

        System.out.println(x);
        System.out.println(rQueue.size());
    }

}

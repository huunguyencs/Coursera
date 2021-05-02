
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;
    private int size;

    // construct an empty deque
    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (head == null) {
            head = new Node(item);
            tail = head;
            size++;
            return;
        }
        Node tmp = head;
        head = new Node(item, tmp);
        tmp.prev = head;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (tail == null) {
            tail = new Node(item);
            head = tail;
            size++;
            return;
        }
        Node tmp = new Node(item, null, tail);
        tail.next = tmp;
        tail = tmp;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item first = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return first;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item last = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return last;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(5);
        deque.addLast(4);
        deque.removeFirst();
        deque.addFirst(8);
        deque.removeLast();
        for (Integer s : deque) {
            System.out.println(s);
        }
    }

    private class Node {
        Item data;
        Node next;
        Node prev;

        Node(Item data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(Item data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = null;
        }

        Node(Item data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.data;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
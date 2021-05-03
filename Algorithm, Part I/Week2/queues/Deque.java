
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

    //
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
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
        if (isEmpty()) {
            tail = new Node(item);
            head = tail;
            size++;
            return;
        }
        Node tmp = tail;
        tail = new Node(item, null, tmp);
        tmp.next = tail;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return data;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Item data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return data;

    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        // deque.addFirst(5);
        // deque.addLast(4);
        // deque.removeFirst();
        // deque.addFirst(8);
        // deque.removeLast();
        // for (Integer s : deque) {
        // System.out.println(s);
        // }
        deque.addFirst(1);
        deque.addFirst(2);
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.isEmpty());
        deque.addFirst(6);
        deque.removeLast();
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
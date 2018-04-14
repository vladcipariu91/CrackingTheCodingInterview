package linkedlist;

public class Queue {

    private Node first;
    private Node last;

    public void add(int data) {
        Node node = new Node(data);
        if (last != null) {
            last.next = node;
        }
        last = node;

        if (first == null) {
            first = node;
        }
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException("Queue");

        int result = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }

        return result;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue");

        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

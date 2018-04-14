package linkedlist;

public class Stack {

    private Node top;

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");

        int result = top.data;
        top = top.next;

        return result;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");

        return top.data;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

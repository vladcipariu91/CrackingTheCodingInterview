import linkedlist.Stack;

public class QueueWithTwoStacks {

    private Stack newest = new Stack();
    private Stack oldest = new Stack();

    public void add(int data) {
        newest.push(data);
    }

    public int remove() {
        transferToOldest();
        return oldest.pop();
    }

    public int peek() {
        transferToOldest();
        return oldest.peek();
    }

    public boolean isEmpty() {
        return newest.isEmpty() && oldest.isEmpty();
    }

    private void transferToOldest() {
        if (oldest.isEmpty()) {
            while (!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }
}

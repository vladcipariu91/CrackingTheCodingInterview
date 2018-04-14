import linkedlist.Node;

public class LinkedListGenerator {

    public Node generate(int[] values) {
        if (values == null || values.length == 0) return null;

        Node head = new Node(values[0]);
        Node currentNode = head;

        for (int i = 1; i < values.length; i++) {
            int value = values[i];
            boolean addsLoop = false;

            Node extraHead = head;
            while (extraHead.next != null) {
                if (value == extraHead.data) {
                    currentNode.next = extraHead;
                    addsLoop = true;
                    break;
                }
                extraHead = extraHead.next;
            }

            if (!addsLoop) {
                Node node = new Node(value);
                currentNode.next = node;
                currentNode = node;
            }
        }

        return head;
    }
}

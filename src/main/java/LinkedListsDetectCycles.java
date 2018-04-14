import linkedlist.Node;

import java.util.HashSet;
import java.util.Set;

public class LinkedListsDetectCycles {

    public static void main(String[] args) {

    }

    // not optimal
    public static boolean hasCycle(Node node) {
        if (node == null) {
            return false;
        }
        Set<Node> visited = new HashSet<>();
        while (node.next != null) {
            if (visited.contains(node)) {
                return true;
            }
            visited.add(node);
            node = node.next;
        }

        return false;
    }

    public static boolean detectLoop(Node head) {
        if (head == null) {
            return false;
        }

        Node slowP = head;
        Node fastP = head;
        while (slowP != null && fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP) {
                System.out.println("Found loop");
                return true;
            }
        }
        return false;
    }
}

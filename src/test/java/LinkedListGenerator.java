public class LinkedListGenerator {

    public LinkedListsDetectCycles.Node generate(int[] values) {
        if (values == null || values.length == 0) return null;

        LinkedListsDetectCycles.Node head = new LinkedListsDetectCycles.Node(values[0]);
        LinkedListsDetectCycles.Node currentNode = head;

        for (int i = 1; i < values.length; i++) {
            int value = values[i];
            boolean addsLoop = false;

            LinkedListsDetectCycles.Node extraHead = head;
            while (extraHead.next != null) {
                if (value == extraHead.data) {
                    currentNode.next = extraHead;
                    addsLoop = true;
                    break;
                }
                extraHead = extraHead.next;
            }

            if (!addsLoop) {
                LinkedListsDetectCycles.Node node = new LinkedListsDetectCycles.Node(value);
                currentNode.next = node;
                currentNode = node;
            }
        }

        return head;
    }
}

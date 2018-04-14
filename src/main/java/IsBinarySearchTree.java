import tree.Node;

public class IsBinarySearchTree {

    public static void main(String[] args) {
        Node root = buildBinaryTree();
        System.out.println(isBst(root) ? "Yes" : "No");
    }

    private static boolean isBst(Node root) {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBst(Node root, int min, int max) {
        return root == null ||
                root.data >= min && root.data <= max &&
                        isBst(root.left, min, root.data - 1) &&
                        isBst(root.right, root.data + 1, max);
    }

    //                4
    //              2   6
    //             1 2 5 7
    private static Node buildBinaryTree() {
        Node root = new Node();
        root.data = 4;

        Node leftFirstLevel = new Node();
        leftFirstLevel.data = 2;

        Node leftRightSecondLevel = new Node();
        leftRightSecondLevel.data = 5;

        Node rightRightSecondLevel = new Node();
        rightRightSecondLevel.data = 7;

        Node leftLeftSecondLevel = new Node();
        leftLeftSecondLevel.data = 1;

        Node rightLeftSecondLevel = new Node();
        rightLeftSecondLevel.data = 2;

        leftFirstLevel.left = leftLeftSecondLevel;
        leftFirstLevel.right = rightLeftSecondLevel;

        Node rightFirstLevel = new Node();
        rightFirstLevel.data = 6;
        rightFirstLevel.left = leftRightSecondLevel;
        rightFirstLevel.right = rightRightSecondLevel;

        root.left = leftFirstLevel;
        root.right = rightFirstLevel;

        return root;
    }
}
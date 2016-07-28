package coding4fun;

/**
 * Checks is a given tree is a valid binary search tree.
 *
 * <pre>
 * Input:
 *   10
 *  /  \
 * 5   15
 *    /  \
 *   11    20
 * Output: true
 *
 * Input:
 *    10
 *  /  \
 * 5   15
 *    /  \
 *   6    20
 * Output: false
 * </pre>
 */
public class Problem38 {
    private static class Node {
        private final int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    private static boolean isBST(Node root) {
        return isBST(root, new PrevNode(Integer.MIN_VALUE));
    }

    private static class PrevNode {
        private int value;

        private PrevNode(int value) {
            this.value = value;
        }
    }

    private static boolean isBST(Node node, PrevNode prev) {
        if (node == null) {
            return true;
        }
        boolean a = isBST(node.left, prev);
        if (prev.value > node.value) {
            return false;
        }
        prev.value = node.value;
        boolean b = isBST(node.right, prev);
        return a & b;
    }

    private static Node createTree1() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(11);
        root.right.right = new Node(20);

        return root;
    }

    private static Node createTree2() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(20);

        return root;
    }

    public static void main(String[] args) {
        System.out.println(isBST(createTree1())); // true
        System.out.println(isBST(createTree2())); // false
    }
}

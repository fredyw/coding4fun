package coding4fun;

/**
 * Invert a binary tree.
 * <p>
 * <pre>
 * Input:
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 *       /
 *      6
 *
 * Output:
 *        1
 *       / \
 *      3   2
 *         / \
 *        5   4
 *         \
 *          6
 * </pre>
 */
public class Problem16 {
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    private static void invert(Node node) {
        if (node == null) {
            return;
        }
        Node left = node.left;
        invert(left);
        Node right = node.right;
        invert(right);
        node.right = left;
        node.left = right;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        invert(root);
        System.out.println(root);
        System.out.println(root.left);
        System.out.println(root.right);
        System.out.println(root.right.left);
        System.out.println(root.right.right);
        System.out.println(root.right.left.right);
    }
}

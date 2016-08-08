package coding4fun;

/**
 * Check if a binary tree is a subtree of another binary tree.
 * <p>
 * <pre>
 * Input:
 * Tree1:
 *     3
 *    / \
 *   4   5
 *  / \
 * 1   2
 *
 * Tree2:
 *   4
 *  / \
 * 1   2
 * Output: true
 *
 * Input:
 * Tree1:
 *     3
 *    / \
 *   4   5
 *  / \
 * 1   2
 *      \
 *       0
 * Tree2:
 *   4
 *  / \
 * 1   2
 * Output: false
 *
 * Input:
 * Tree1:
 *          3
 *         / \
 *        4   5
 *       / \
 *     4    3
 *    / \    \
 *   5   7    4
 *  /        / \
 * 4        1   2
 *  \
 *   8
 * Tree2:
 *   4
 *  / \
 * 1   2
 * Output: false
 *
 * Input:
 * Tree1:
 *   4
 *  / \
 * 1   2
 * Tree2:
 *   4
 *  / \
 * 1   2
 * Output: true
 * </pre>
 */
public class Problem36 {
    private static class Node {
        private final int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    private static boolean contains(Node biggerTree, Node smallerTree) {
        if (biggerTree == null && smallerTree == null) {
            return true;
        } else if ((biggerTree == null && smallerTree != null) ||
            (biggerTree != null && smallerTree == null)) {
            return false;
        }
        if (biggerTree.val == smallerTree.val) {
            boolean a = contains(biggerTree.left, smallerTree.left);
            boolean b = contains(biggerTree.right, smallerTree.right);
            // we found the subtree
            if (a && b == true) {
                return true;
            }
        }
        boolean a = contains(biggerTree.left, smallerTree);
        boolean b = contains(biggerTree.right, smallerTree);
        return a || b;
    }

    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left) + 1;
        int right = getHeight(node.right) + 1;
        return Math.max(left, right);
    }

    private static Node createTree1() {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);

        return root;
    }

    private static Node createTree2() {
        Node root = new Node(4);
        root.left = new Node(1);
        root.right = new Node(2);

        return root;
    }

    private static void testCase1() {
        Node tree1 = createTree1();
        Node tree2 = createTree2();

        int length1 = getHeight(tree1);
        int length2 = getHeight(tree2);

        if (length1 < length2) {
            System.out.println(contains(tree2, tree1));
        } else {
            System.out.println(contains(tree1, tree2));
        }
    }

    private static Node createTree3() {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);
        root.left.right.left = new Node(0);

        return root;
    }

    private static Node createTree4() {
        Node root = new Node(4);
        root.left = new Node(1);
        root.right = new Node(2);

        return root;
    }

    private static void testCase2() {
        Node tree1 = createTree3();
        Node tree2 = createTree4();

        int length1 = getHeight(tree1);
        int length2 = getHeight(tree2);

        if (length1 < length2) {
            System.out.println(contains(tree2, tree1));
        } else {
            System.out.println(contains(tree1, tree2));
        }
    }

    private static Node createTree5() {
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);
        root.left.right.right.left = new Node(1);
        root.left.right.right.right = new Node(2);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(7);
        root.left.left.left.left = new Node(4);
        root.left.left.left.left.right = new Node(8);

        return root;
    }

    private static Node createTree6() {
        Node root = new Node(4);
        root.left = new Node(1);
        root.right = new Node(2);

        return root;
    }

    private static void testCase3() {
        Node tree1 = createTree5();
        Node tree2 = createTree6();

        int length1 = getHeight(tree1);
        int length2 = getHeight(tree2);

        if (length1 < length2) {
            System.out.println(contains(tree2, tree1));
        } else {
            System.out.println(contains(tree1, tree2));
        }
    }

    private static Node createTree7() {
        Node root = new Node(4);
        root.left = new Node(1);
        root.right = new Node(2);

        return root;
    }

    private static Node createTree8() {
        Node root = new Node(4);
        root.left = new Node(1);
        root.right = new Node(2);

        return root;
    }

    private static void testCase4() {
        Node tree1 = createTree7();
        Node tree2 = createTree8();

        int length1 = getHeight(tree1);
        int length2 = getHeight(tree2);

        if (length1 < length2) {
            System.out.println(contains(tree2, tree1));
        } else {
            System.out.println(contains(tree1, tree2));
        }
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
    }
}

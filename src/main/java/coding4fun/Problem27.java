package coding4fun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Check if a binary search tree is valid.
 * <p>
 * <pre>
 * Input:
 *            5
 *          /   \
 *         3     8
 *        / \   / \
 *       1   4 7   9
 *        \   /
 *         2 6
 * Output: true
 *
 * Input:
 *            5
 *          /   \
 *         3     8
 *        / \   / \
 *       1   6 7   9
 *        \   /
 *         2 4
 * Output: false
 *
 * Input:
 *            5
 *          /   \
 *         3     8
 *        / \   / \
 *       1   6 7   9
 *      /     /
 *     2     4
 * Output: false
 * </pre>
 */
public class Problem27 {
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

    public static boolean isValid(Node root) {
        LinkedList<Node> nodeList = new LinkedList<>();
        List<Integer> numbers = new ArrayList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            Node node = nodeList.remove();
            numbers.add(node.value);
            if (node.left != null) {
                nodeList.add(node.left);
            }
            if (node.right != null) {
                nodeList.add(node.right);
            }
        }
        Node expected = buildTree(numbers);
        return isValid(root, expected);
    }

    private static Node buildTree(List<Integer> numbers) {
        Node node = null;
        for (int num : numbers) {
            node = buildTree(node, num);
        }
        return node;
    }

    private static Node buildTree(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (node.value >= value) {
            node.left = buildTree(node.left, value);
        } else {
            node.right = buildTree(node.right, value);
        }
        return node;
    }

    private static boolean isValid(Node actual, Node expected) {
        if (actual == null && expected == null) {
            return true;
        }
        if ((actual == null && expected != null) ||
            (actual != null && expected == null)) {
            return false;
        }
        if (actual.value != expected.value) {
            return false;
        }
        boolean valid1 = isValid(actual.left, expected.left);
        boolean valid2 = isValid(actual.right, expected.right);
        return valid1 && valid2;
    }

    private static void testCase1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node5.left = node3;
        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
        node5.right = node8;
        node8.left = node7;
        node8.right = node9;
        node7.left = node6;

        System.out.println(isValid(node5));
    }

    private static void testCase2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node5.left = node3;
        node3.left = node1;
        node3.right = node6;
        node1.right = node2;
        node5.right = node8;
        node8.left = node7;
        node8.right = node9;
        node7.left = node4;

        System.out.println(isValid(node5));
    }

    private static void testCase3() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node5.left = node3;
        node3.left = node1;
        node3.right = node6;
        node1.left = node2;
        node5.right = node8;
        node8.left = node7;
        node8.right = node9;
        node7.left = node4;

        System.out.println(isValid(node5));
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }
}

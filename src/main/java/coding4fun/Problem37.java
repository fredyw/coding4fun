package coding4fun;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and two values, find the lowest common ancestor.
 *
 * <pre>
 *          1
 *        /   \
 *       2     3
 *      / \   / \
 *     4   5 6   7
 *
 * Input: 4, 5
 * Output: 1
 *
 * Input: 4, 6
 * Output: 1
 *
 * Input: 3, 4
 * Output: 1
 *
 * Input: 2, 4
 * Output: 2
 *
 * Input: 1, 2
 * Output: 1
 * </pre>
 */
public class Problem37 {
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

    private static int lowestCommonAncestor(Node root, int val1, int val2) {
        List<Integer> path1 = findPath(root, val1);
        List<Integer> path2 = findPath(root, val2);
        if (path1.size() > path2.size()) {
            return lca(path1, path2);
        }
        return lca(path2, path1);
    }

    private static int lca(List<Integer> path1, List<Integer> path2) {
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        // we can choose either path1.get(i + 1) or path2.get(j + 1), both will return the LCA
        return path1.get(i + 1);
    }

    private static List<Integer> findPath(Node node, int value) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.value == value) {
            List<Integer> list = new ArrayList<>();
            list.add(value);
            return list;
        }
        List<Integer> left = findPath(node.left, value);
        if (!left.isEmpty()) {
            left.add(node.value);
            return left;
        }
        List<Integer> right = findPath(node.right, value);
        if (!right.isEmpty()) {
            right.add(node.value);
            return right;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lowestCommonAncestor(root, 4, 5)); // 2
        System.out.println(lowestCommonAncestor(root, 4, 6)); // 1
        System.out.println(lowestCommonAncestor(root, 3, 4)); // 1
        System.out.println(lowestCommonAncestor(root, 2, 4)); // 2
        System.out.println(lowestCommonAncestor(root, 1, 2)); // 1
    }
}

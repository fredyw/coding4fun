package coding4fun;

import java.util.ArrayList;
import java.util.List;

/**
 * Get the ancestors of a given node in a binary tree.
 *
 * <pre>
 *           1
 *         /   \
 *       2      3
 *     /  \
 *   4     5
 *  /
 * 7
 *
 * Input : 7
 * Output: [4, 2, 1]
 *
 * Input : 5
 * Output: [2, 1]
 *
 * Input : 3
 * Output: [1]
 *
 * Input : 1
 * Output: []
 * </pre>
 */
public class Problem57 {
    private static class TreeNode {
        private final int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<Integer> getAncestors(TreeNode root, int value) {
        List<Integer> ancestors = new ArrayList<>();
        getAncestors(root, value, ancestors);
        return ancestors;
    }

    private static boolean getAncestors(TreeNode root, int value, List<Integer> ancestors) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        boolean a = getAncestors(root.left, value, ancestors);
        boolean b = getAncestors(root.right, value, ancestors);
        boolean c = a || b;
        if (c) {
            ancestors.add(root.value);
        }
        return c;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(getAncestors(root, 7)); // [4, 2, 1]
        System.out.println(getAncestors(root, 5)); // [2, 1]
        System.out.println(getAncestors(root, 3)); // [1]
        System.out.println(getAncestors(root, 1)); // []
    }
}

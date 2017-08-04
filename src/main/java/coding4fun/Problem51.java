package coding4fun;

/**
 * Build a binary tree from the serialized binary tree string (https://leetcode.com/faq/#binary-tree)
 */
public class Problem51 {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public static TreeNode build(String str) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = build("[]");
        root = build("[1,2,3]");
        root = build("[1,null,2,3]");
        root = build("[5,4,7,3,null,2,null,-1,null,9]");
    }
}

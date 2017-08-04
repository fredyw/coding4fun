package coding4fun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

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

    private static TreeNode deserialize(String str) {
        String[] nodes = str.substring(1, str.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int idx = 0;
        String val = nodes[idx];
        if (val.isEmpty()) {
            return null;
        }
        TreeNode root = null;
        queue.add(new TreeNode(Integer.parseInt(val)));
        while (!queue.isEmpty()) {
            TreeNode parent = queue.remove();
            if (idx == 0) {
                root = parent;
            }
            if (++idx < nodes.length) {
                if (!nodes[idx].equals("null")) {
                    parent.left = new TreeNode(Integer.parseInt(nodes[idx]));
                    queue.add(parent.left);
                }
            }
            if (++idx < nodes.length) {
                if (!nodes[idx].equals("null")) {
                    parent.right = new TreeNode(Integer.parseInt(nodes[idx]));
                    queue.add(parent.right);
                }
            }
        }
        return root;
    }

    public static String serialize(TreeNode node) {
        if (node == null) {
            return "[]";
        }
        List<String> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        nodes.add(Integer.toString(node.val));
        while (!queue.isEmpty()) {
            TreeNode parent = queue.remove();
            if (parent.left == null) {
                nodes.add("null");
            } else {
                queue.add(parent.left);
                nodes.add(Integer.toString(parent.left.val));
            }
            if (parent.right == null) {
                nodes.add("null");
            } else {
                queue.add(parent.right);
                nodes.add(Integer.toString(parent.right.val));
            }
        }
        // remove all the nulls from behind
        int i = nodes.size() - 1;
        while (nodes.get(i).equals("null")) {
            i--;
        }
        nodes = nodes.subList(0, i + 1);
        return "[" + nodes.stream().collect(Collectors.joining(",")) + "]";
    }

    public static void main(String[] args) {
        TreeNode root = deserialize("[]");
        System.out.println(serialize(root));

        root = deserialize("[1,2,3]");
        System.out.println(serialize(root));

        root = deserialize("[1,null,2,3]");
        System.out.println(serialize(root));

        root = deserialize("[5,4,7,3,null,2,null,-1,null,9]");
        System.out.println(serialize(root));

        root = deserialize("[1,-1,2,null,null,3]");
        System.out.println(serialize(root));
    }
}

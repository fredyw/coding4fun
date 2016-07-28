package coding4fun;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the maximum subtree from a given binary tree where the subtree has the following
 * property:
 * 
 * Left child < parent < right child
 *
 * <pre>
 * Input:
 *       1
 *      / \
 *     5   3
 *    / \   \
 *   2   9   8
 *      / \
 *     7  12
 *    / \   \
 *   10  9  13
 *  /       /
 * 6       15
 *        /  \
 *       4   18
 *
 * Output:
 *         subtree:  5
 *                  / \
 *                 2   9
 *                    / \
 *                   7  12
 *                       \
 *                       13
 * </pre>
 */
public class Problem40 {
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

    private static class Group {
        private int group;
    }

    private static int maxSubtree(Node root) {
        Map<Integer, Integer> groupCount = new HashMap<>();
        maxSubtree(root, new Group(), groupCount, 0);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : groupCount.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        return max + 1; // include the root
    }

    private static void maxSubtree(Node node, Group group, Map<Integer, Integer> groupCount,
                                   int groupNumber) {
        if (node == null) {
            return;
        }
        int newGroupNumber = groupNumber;
        int leftGroupNumber = newGroupNumber;
        int rightGroupNumber = newGroupNumber;
        if (node.left != null && node.right != null) {
            if (node.left.value < node.value && node.value < node.right.value) {
                if (!groupCount.containsKey(newGroupNumber)) {
                    groupCount.put(newGroupNumber, 2);
                } else {
                    groupCount.put(newGroupNumber, groupCount.get(newGroupNumber) + 2);
                }
            } else {
                leftGroupNumber = group.group++;
                rightGroupNumber = group.group++;
            }
        } else if (node.left != null) {
            if (node.left.value < node.value) {
                if (!groupCount.containsKey(newGroupNumber)) {
                    groupCount.put(newGroupNumber, 1);
                } else {
                    groupCount.put(newGroupNumber, groupCount.get(newGroupNumber) + 1);
                }
            } else {
                leftGroupNumber = group.group++;
            }
        } else if (node.right != null) {
            if (node.value < node.right.value) {
                if (!groupCount.containsKey(newGroupNumber)) {
                    groupCount.put(newGroupNumber, 1);
                } else {
                    groupCount.put(newGroupNumber, groupCount.get(newGroupNumber) + 1);
                }
            } else {
                rightGroupNumber = group.group++;
            }
        }
        maxSubtree(node.left, group, groupCount, leftGroupNumber);
        maxSubtree(node.right, group, groupCount, rightGroupNumber);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(9);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(12);
        root.left.right.left.left = new Node(10);
        root.left.right.left.right = new Node(9);
        root.left.right.left.left.left = new Node(6);
        root.left.right.right.right = new Node(13);
        root.left.right.right.right.left = new Node(15);
        root.left.right.right.right.left.left = new Node(4);
        root.left.right.right.right.left.right = new Node(18);
        root.right = new Node(3);
        root.right.right = new Node(8);

        System.out.println(maxSubtree(root));
    }
}

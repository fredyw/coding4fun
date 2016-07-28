package coding4fun;

/**
 *
 */
public class Problem39 {
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

//    private static class Group {
//        private int group;
//    }
//
//    private static int maxBST(Node root) {
//        Map<Integer, Integer> groupCount = new HashMap<>();
//        maxBST(root, new Group(), groupCount, 0);
//        System.out.println(groupCount);
//        return 0;
//    }
//
//    private static void maxBST(Node node, Group group, Map<Integer, Integer> groupCount,
//                               int groupNumber) {
//        if (node == null) {
//            return;
//        }
//        int newGroupNumber = groupNumber;
//        int leftGroupNumber = newGroupNumber;
//        int rightGroupNumber = newGroupNumber;
//        if (node.left != null && node.right != null) {
//            if (node.left.value < node.value && node.value < node.right.value) {
//                if (!groupCount.containsKey(newGroupNumber)) {
//                    System.out.println("root both: " + node + ", group: " + newGroupNumber);
//                    groupCount.put(newGroupNumber, 2);
//                } else {
//                    groupCount.put(newGroupNumber, groupCount.get(newGroupNumber) + 2);
//                }
//            } else {
//                leftGroupNumber = group.group++;
//                rightGroupNumber = group.group++;
//            }
//        } else if (node.left != null) {
//            if (node.left.value < node.value) {
//                if (!groupCount.containsKey(newGroupNumber)) {
//                    System.out.println("root left: " + node + ", group: " + newGroupNumber);
//                    groupCount.put(newGroupNumber, 1);
//                } else {
//                    groupCount.put(newGroupNumber, groupCount.get(newGroupNumber) + 1);
//                }
//            } else {
//                leftGroupNumber = group.group++;
//            }
//        } else if (node.right != null) {
//            if (node.value < node.right.value) {
//                if (!groupCount.containsKey(newGroupNumber)) {
//                    System.out.println("root right: " + node + ", group: " + newGroupNumber);
//                    groupCount.put(newGroupNumber, 1);
//                } else {
//                    groupCount.put(newGroupNumber, groupCount.get(newGroupNumber) + 1);
//                }
//            } else {
//                rightGroupNumber = group.group++;
//            }
//        }
//        maxBST(node.left, group, groupCount, leftGroupNumber);
//        maxBST(node.right, group, groupCount, rightGroupNumber);
//    }

    private static int maxBST(Node root) {
        if (isBST(root)) {
            System.out.println("root: " + root + " --> " + size(root));
            return size(root);
        }
        return Math.max(maxBST(root.left), maxBST(root.right));
    }

    private static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
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

        System.out.println(maxBST(root));
    }
}

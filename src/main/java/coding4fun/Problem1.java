package coding4fun;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a binary search tree, design an algorithm which creates a linked list
 * of all the nodes at each depth.
 * <p>
 * (i e , if you have a tree with depth D, you’ll have D linked lists)
 * <p>
 * <pre>
 *              (5)
 *             /   \
 *            /     \
 *          (3)     (7)
 *         /  \     / \
 *       (2)  (4) (6) (8)
 *       /              \
 *     (1)              (9)
 * </pre>
 * <p>
 * Will return linked lists:
 * <pre>
 * (5) => NULL
 * (3) => (7) => NULL
 * (2) => (4) => (6) => (8) => NULL
 * (1) => (9) => NULL
 * </pre>
 */
public class Problem1 {
    private static class Node {
        Node left;
        Node right;
        int value;

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    private static class BinaryTree {
        Node root;

        public void add(int value) {
            root = add(root, value);
        }

        Node add(Node node, int value) {
            if (node == null) {
                Node n = new Node();
                n.value = value;
                return n;
            }
            if (value <= node.value) {
                node.left = add(node.left, value);
            } else {
                node.right = add(node.right, value);
            }
            return node;
        }
    }

    private static class NodeDepth {
        int depth;
        Node node;

        public NodeDepth(int depth, Node node) {
            this.depth = depth;
            this.node = node;
        }

        @Override
        public String toString() {
            return node.toString();
        }
    }

    public static Map<Integer, LinkedList<Node>> buildLinkedLists(Node root) {
        Queue<NodeDepth> queue = new LinkedList<>();
        int idx = 0;
        queue.add(new NodeDepth(idx, root));
        Map<Integer, LinkedList<Node>> result = new HashMap<>();
        while (!queue.isEmpty()) {
            NodeDepth n = queue.remove();
            if (!result.containsKey(n.depth)) {
                result.put(n.depth, new LinkedList<Node>());
            }
            result.get(n.depth).add(n.node);
            if (n.node.left != null) {
                queue.add(new NodeDepth(n.depth + 1, n.node.left));
            }
            if (n.node.right != null) {
                queue.add(new NodeDepth(n.depth + 1, n.node.right));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(5);
        bt.add(3);
        bt.add(7);
        bt.add(2);
        bt.add(4);
        bt.add(6);
        bt.add(8);
        bt.add(1);
        bt.add(9);
        Map<Integer, LinkedList<Node>> map = buildLinkedLists(bt.root);
        for (int i = 0; i < map.size(); i++) {
            System.out.print(i + 1 + " => ");
            System.out.println(map.get(i));
        }
    }
}

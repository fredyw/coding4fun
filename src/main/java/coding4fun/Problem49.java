package coding4fun;

/**
 * Check if a linked list is a palindrome without any extra space.
 *
 * <pre>
 * Input : 1->2->3->2->1
 * Output: true
 *
 * Input : 1->2->3->3->2->1
 * Output: true
 *
 * Input : 1->2->3->4->1
 * Output: false
 *
 * Input : 1->2->3->4->2->1
 * Output: false
 * </pre>
 */
public class Problem49 {
    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    public static boolean isPalindrome(Node node) {
        int size = 0;
        for (Node n = node; n != null; n = n.next) {
            size++;
        }
        int mid = size / 2;
        Node right = node;
        for (int i = 1; i <= ((size % 2 == 0) ? mid : mid + 1); i++) {
            right = right.next;
        }
        Ref ref = new Ref();
        reverse(node, mid, 1, ref);
        Node left = ref.node;
        for (Node a = left, b = right; a != null || b != null; a = a.next, b = b.next) {
            if (a.value != b.value) {
                return false;
            }
        }
        return true;
    }

    private static class Ref {
        Node node;
    }

    private static Node reverse(Node node, int mid, int i, Ref ref) {
        if (i == mid) {
            ref.node = node;
            return node;
        }
        Node n = reverse(node.next, mid, i + 1, ref);
        node.next = null;
        n.next = node;
        return node;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(node)); // true

        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(2);
        node.next.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(node)); // true

        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(node)); // false

        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(2);
        node.next.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(node)); // false
    }
}

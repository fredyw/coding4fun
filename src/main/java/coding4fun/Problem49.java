package coding4fun;

/**
 * Check if a linked list is a palindrome. Must use O(1) space.
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

        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(node)); // true

//        node.next = new Node(2);
//        node.next.next = new Node(3);
//        node.next.next.next = new Node(3);
//        node.next.next.next.next = new Node(2);
//        node.next.next.next.next.next = new Node(1);
//        System.out.println(isPalindrome(node)); // true
//
//        node = new Node(1);
//        node.next = new Node(2);
//        node.next.next = new Node(3);
//        node.next.next.next = new Node(4);
//        node.next.next.next.next = new Node(1);
//        System.out.println(isPalindrome(node)); // false
    }
}

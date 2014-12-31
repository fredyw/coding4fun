package coding4fun;

/**
 * Reverse a linked list in-place.
 * <pre>
 * Input:  1 -> 2 -> 3 -> 4 -> 5
 * Output: 5 -> 4 -> 3 -> 2 -> 1
 * 
 * Input:  1
 * Output: 1
 * </pre>
 */
public class Problem14 {
    private static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode l) {
        ListNode prev = null;
        ListNode current = l;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    private static void print(ListNode l) {
        for (ListNode n = l; n != null; n = n.next) {
            if (n.next == null) {
                System.out.print(n.val);
            } else {
                System.out.print(n.val + " -> ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        print(reverse(l));
        
        l = new ListNode(1);
        print(reverse(l));
    }
}

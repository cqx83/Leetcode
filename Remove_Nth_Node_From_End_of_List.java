public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode s = d, f = d;
        while(n-- > 0) {
            f = f.next;
        }
        while(f.next != null) {
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;
        return d.next;
    }
}
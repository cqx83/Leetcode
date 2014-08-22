public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode d = new ListNode(0);
        d.next = head;
        head = d;
        while(head.next != null && head.next.next != null) {
            ListNode t = head.next.next;
            head.next.next = t.next;
            t.next = head.next;
            head.next = t;
            head = head.next.next;
        }
        return d.next;
    }
}
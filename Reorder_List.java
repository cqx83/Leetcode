public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode t = slow.next;
        while(t.next != null) {
            ListNode tmp = t.next;
            t.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }
        
        ListNode nh = slow.next, oh = head;
        slow.next = null;
        while(nh != null) {
            ListNode tmp = nh;
            nh = nh.next;
            tmp.next = oh.next;
            oh.next = tmp;
            oh = oh.next.next;
        }
    }
}
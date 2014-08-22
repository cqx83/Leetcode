public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null)    return null;
        if(head.next == null)   return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(second);
        ListNode res = combine(l,r);
        return res;
    }
    
    ListNode combine(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l != null && r != null) {
            if(l.val <= r.val) {
                head.next = l;
                l = l.next;
            } else {
                head.next = r;
                r = r.next;
            }
            head = head.next;
        }
        head.next = l != null ? l : r;
        return dummy.next;
    }
}
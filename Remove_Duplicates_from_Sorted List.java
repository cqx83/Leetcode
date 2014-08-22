public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = head;
        while(h != null) {
            while(h.next != null && h.next.val == h.val)
                h.next = h.next.next;
            h = h.next;
        }
        return head;
    }
}
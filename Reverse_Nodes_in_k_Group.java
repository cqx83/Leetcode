public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        for(ListNode tmp = dummy; tmp.next != null; tmp = tmp.next)
            len++;
        ListNode pre = dummy, cur = head;
        for(int i=0; i<len/k; i++) {
            for(int j=0; j<k-1; j++) {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            pre = cur;
            cur = pre.next;
        }
        return dummy.next;
    }
}
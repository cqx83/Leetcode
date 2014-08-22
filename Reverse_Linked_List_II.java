public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode preM = null, iter = d;
        for(int i=1; i<=n; i++) {
            if(i <= m) {
                preM = i == m ? iter : null;
                iter = iter.next;
            } else if(i > m && i <= n) {
                ListNode tmp = iter.next;
                iter.next = iter.next.next;
                tmp.next = preM.next;
                preM.next = tmp;
            }
        }
        return d.next;
    }
}
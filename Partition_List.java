public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(0), gt = new ListNode(0);
        ListNode lth = lt, gth = gt;
        for (;head != null ; head = head.next) {
            if(head.val < x) {
                lth.next = head;
                lth = lth.next;
            } else {
                gth.next = head;
                gth = gth.next;
            }      
        }
        lth.next = gt.next;
        gth.next = null;
        return lt.next;   
    }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode d = new ListNode(0);
        d.next = head;
        head = d;
        while(head.next != null) {
            int v = head.next.val;
            ListNode iter = head.next;
            boolean delete = false;
            while(iter.next != null && iter.next.val == v) {
                delete = true;
                iter.next = iter.next.next;
            }
            if(delete)  head.next = head.next.next;
            else head = head.next;
        }
        return d.next;
    }
}
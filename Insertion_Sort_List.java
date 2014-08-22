public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iter = dummy;
        while(iter.next != null) {
        	ListNode s;
        	for(s = dummy; s.next.val < iter.next.val && s != iter; s = s.next);
        	if(s != iter) {
        		ListNode tmp = iter.next;
        		iter.next = tmp.next;
        		tmp.next = s.next;
        		s.next = tmp;
        	} else {
        		iter = iter.next;
        	}
        }
        return dummy.next;
    }
}
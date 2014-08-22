public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
    	if(head == null)	return	null;
    	ListNode l = head, r = head;
    	int len = 1;
    	for(; r.next != null; r = r.next)	len++;
    	int k = len - n%len;
    	while(k-- > 0) {
    		r.next = l;
    		l = l.next;
    		r = r.next;
    		r.next = null;
    	}
    	return l;
    }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode s = head, f = head;
        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if(f == s)  return true;
        }
        return false;
    }
}
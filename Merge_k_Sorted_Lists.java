public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)   return null;
        Queue<ListNode> pq = new PriorityQueue(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if(n1.val == n2.val)    return 0;
                return n1.val < n2.val ? -1 : 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int i=0; i<lists.size(); i++) {
            if(lists.get(i) != null)
                pq.add(lists.get(i));
        }
        while(pq.size() > 0) {
            ListNode cur = pq.poll();
            if(cur.next != null)    pq.add(cur.next);
            head.next = cur;
            head = head.next;
        }
        return dummy.next;
    }
}
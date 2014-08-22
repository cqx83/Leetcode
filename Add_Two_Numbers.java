public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,false);
    }

    ListNode add(ListNode l1, ListNode l2, boolean carry) {
        if(l1 == null && l2 == null && !carry)  return null;
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (carry ? 1 : 0);
        ListNode node = new ListNode(sum%10);
        node.next = add((l1==null ? null : l1.next),(l2==null ? null : l2.next),(sum/10>0 ? true : false));
        return node;
    }
}
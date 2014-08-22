public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode res = null;
        for (RandomListNode iter = head; iter != null; iter = iter.next) {
            RandomListNode copy = new RandomListNode(iter.label);
            if(iter == head)    res = copy;
            copy.next = iter.random;
            iter.random = copy;
        }
        for (RandomListNode iter = head; iter != null; iter = iter.next) {
            RandomListNode copy = iter.random;
            copy.random = copy.next == null ? null : copy.next.random;
        }
        for (RandomListNode iter = head; iter != null; iter = iter.next) {
            RandomListNode copy = iter.random;
            RandomListNode tmp = copy.next;
            copy.next = iter.next == null ? null : iter.next.random;
            iter.random = tmp;
        }
        return res;
    }
}
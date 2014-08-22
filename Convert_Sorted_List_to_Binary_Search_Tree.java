public class Solution {

    ListNode iter;

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)    return null;
        int n = 0;
        for(ListNode it = head; it != null; it = it.next)
            n++;
        iter = head;
        return fun(0,n-1);
    }

    TreeNode fun(int l, int r) {
        if(l > r)   return null;
        int mid = l+(r-l)/2;
        TreeNode lc = fun(l,mid-1);
        TreeNode p = new TreeNode(iter.val);
        iter = iter.next;
        TreeNode rc = fun(mid+1,r);
        p.left = lc;
        p.right = rc;
        return p;
    }
}
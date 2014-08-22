public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while(head != null) {
            TreeLinkNode pre = null, next = null;
            for(TreeLinkNode iter = head; iter != null; iter = iter.next) {
                if(iter.left != null) {
                    if(pre != null) pre.next = iter.left;
                    pre = iter.left;
                }
                if(iter.right != null) {
                    if(pre != null) pre.next = iter.right;
                    pre = iter.right;
                }
                if(next == null)
                    next = iter.left == null ? iter.right : iter.left;
            }
            head = next;
        }
    }
}
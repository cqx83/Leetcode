public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null) {
            TreeLinkNode next = null, pre = null;
            for(; root != null; root = root.next) {
                if(root.left != null) {
                    if(pre != null) {
                        pre.next = root.left;
                    }
                    pre = root.left;
                    next = next == null ? pre : next;
                }
                if(root.right != null) {
                    if(pre != null) {
                        pre.next = root.right;
                    }
                    pre = root.right;
                    next = next == null ? pre : next;
                }
            }
            root = next;
        }
    }
}
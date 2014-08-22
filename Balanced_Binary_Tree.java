public class Solution {
    public boolean isBalanced(TreeNode root) {
        return get(root) != -1;
    }

    int get(TreeNode root) {
        if(root == null)    return 0;
        int lc = get(root.left);
        int rc = get(root.right);
        if(lc == -1 || rc == -1)    return -1;
        return Math.abs(lc-rc)>1 ? -1 : Math.max(lc,rc)+1;
    }
}
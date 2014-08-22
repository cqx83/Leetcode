public class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }

    TreeNode helper(TreeNode root) {
        if(root == null)    return null;
        if(root.left == null && root.right == null) return root;
        TreeNode lc = helper(root.left);
        TreeNode rc = helper(root.right);
        if(lc == null)  return rc;
        lc.right = root.right;
        root.right = root.left;
        root.left = null;
        return rc == null ? lc : rc;
    }
}
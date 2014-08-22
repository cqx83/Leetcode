public class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if(root == null)    return 0;
        int v = root.val;
        int vl = dfs(root.left), vr = dfs(root.right);
        int res = Math.max(v,Math.max(v+vr,v+vl));
        max = Math.max(max,Math.max(res,v+vl+vr));
        return res;
    }
}
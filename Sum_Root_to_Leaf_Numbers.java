 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    int dfs(TreeNode root, int sum) {
        if(root == null)    return 0;
        int v = root.val + sum*10;
        if(root.left == null && root.right == null) 
            return  v;
        return dfs(root.left,v) + dfs(root.right,v);
    }
}
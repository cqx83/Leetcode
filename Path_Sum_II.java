public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        dfs(root,sum,stack,res);
        return res;
    }

    void dfs(TreeNode root, int sum, Stack<Integer> stack, ArrayList<ArrayList<Integer>> res) {
        if(root == null)    return;
        int v = root.val;
        if(root.left == null && root.right == null && v == sum) {
            stack.push(v);
            res.add(new ArrayList<Integer>(stack));
            stack.pop();
            return;
        }
        stack.push(v);
        dfs(root.left,sum-v,stack,res);
        dfs(root.right,sum-v,stack,res);
        stack.pop();
    }
}
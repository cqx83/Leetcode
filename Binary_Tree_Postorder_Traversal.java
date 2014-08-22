// Iteration
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(root != null || !stack.empty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else if(stack.peek().right != null && stack.peek().right != pre) {
                root = stack.peek().right;
            } else {
                TreeNode p = stack.pop();
                res.add(p.val);
                pre = p;
            }
        }
        return res;
    }
}
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.empty()) {
            if(root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return res;
    }
}

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }
    
    public void helper(TreeNode root, ArrayList<Integer> res) {
        if(root == null)    return;
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
    }
}
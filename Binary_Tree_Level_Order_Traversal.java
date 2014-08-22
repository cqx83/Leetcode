public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)    return res;
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        cur.add(root);
        while(cur.size() > 0) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            for(TreeNode iter : cur) {
                sub.add(iter.val);
                if(iter.left != null)    next.add(iter.left);
                if(iter.right != null)   next.add(iter.right);
            }
            if(sub.size() > 0)  res.add(sub);
            cur = next;
            next = new ArrayList<TreeNode>();
        }
        return res;
    }
}
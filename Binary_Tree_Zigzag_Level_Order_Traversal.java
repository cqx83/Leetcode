public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)    return res;
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        cur.add(root);
        boolean order = false;
        while(cur.size() > 0) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            for(TreeNode iter : cur)    sub.add(iter.val);
            res.add(sub);
            for(int i=cur.size()-1; i>=0; i--) {
                TreeNode iter = cur.get(i);
                if(order) {
                    if(iter.left != null)   next.add(iter.left);
                    if(iter.right != null)   next.add(iter.right);
                } else {
                    if(iter.right != null)   next.add(iter.right);
                    if(iter.left != null)   next.add(iter.left);
                }
            }
            order = !order;
            cur = next;
            next = new ArrayList<TreeNode>();
        }        
        return res;
    }
}
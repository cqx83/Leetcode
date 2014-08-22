public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return build(1,n);
    }

    ArrayList<TreeNode> build(int l, int r) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(l>r) {
            res.add(null);
            return res;
        }
        for (int i=l; i<=r; i++) {
            ArrayList<TreeNode> left = build(l,i-1);
            ArrayList<TreeNode> right = build(i+1,r);
            for(TreeNode lt : left) {
                for(TreeNode rt : right) {
                    TreeNode nw = new TreeNode(i);
                    nw.left = lt;
                    nw.right = rt;
                    res.add(nw);
                }
            }
        }
        return res;
    }
}
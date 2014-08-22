public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        return helper(inorder,0,len-1,preorder,0,len-1);
    }
    
    public TreeNode helper(int[] io, int il, int ir, int[] po, int pl, int pr) {
        if(il > ir)
            return null;
        if(il == ir)
            return new TreeNode(io[il]);
        int rootVal = po[pl], index = -1;
        for(int i=il; i<=ir; i++) {
            if(io[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(io,il,index-1,po,pl+1,pl+index-il);
        root.right = helper(io,index+1,ir,po,pl+index-il+1,pr);
        return root;
    }
}
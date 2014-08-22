public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return fun(num,0,num.length-1);   
    }

    TreeNode fun(int[] num, int l, int r) {
        if(l > r)   return null;
        if(l == r)  return new TreeNode(num[l]);
        int mid = l+(r-l)/2;
        TreeNode p = new TreeNode(num[mid]);
        p.left = fun(num,l,mid-1);
        p.right = fun(num,mid+1,r);
        return p;
    }
}
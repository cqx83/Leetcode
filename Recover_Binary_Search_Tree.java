public class Solution {
	TreeNode first = null, second = null, pre = null;
	public void recoverTree(TreeNode root) {
		while(root != null) {
			if(root.left == null) {
				visit(root);
				root = root.right;
			} else {
				TreeNode t = root.left;
				while(t.right != null && t.right != root)	t = t.right;
				if(t.right == null) {
					t.right = root;
					root = root.left;
				} else {
					t.right = null;
					visit(root);
					root = root.right;
				}
			}
		}
		int v = first.val;
		first.val = second.val;
		second.val = v;
	}
	
	void visit(TreeNode root) {
		if(pre == null)	{
			pre = root;
			return;
		}
		if(root.val < pre.val) {
			first = first == null ? pre : first;
			second = root;
		}
		pre = root;
	}
}
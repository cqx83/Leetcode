// Morris inorder traversal O(1) space no recursion
public class Solution {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(root != null) {
			if(root.left == null) {
				res.add(root.val);
				root = root.right;
			} else {
				TreeNode t = root.left;
				while(t.right != null && t.right != root)	t = t.right;
				if(t.right == null) {
					t.right = root;
					root = root.left;
				} else {
					t.right = null;
					res.add(root.val);
					root = root.right;
				}
			}
		}
		return res;
	}
}

// Iteration
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.empty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode p = stack.pop();
                res.add(p.val);
                root = p.right;
            }
        }        
        return res;
    }
}

// Recursive
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res =  new ArrayList<Integer>();
        dfs(root,res);
        return res;
    }

    void dfs(TreeNode root, ArrayList<Integer> res) {
        if(root == null)    return;
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }
}
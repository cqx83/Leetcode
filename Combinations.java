public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        dfs(1,n,k,stack,res);
        return res;
    }

    void dfs(int s, int e, int k, Stack<Integer> stack, ArrayList<ArrayList<Integer>> res) {
        if(stack.size() == k) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        for(int i=s; i<=e; i++) {
            stack.push(i);
            dfs(i+1,e,k,stack,res);
            stack.pop();
        }
    }
}
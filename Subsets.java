public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        Arrays.sort(S);
        dfs(S,0,stack,res);
        return res;
    }

    void dfs(int[] S, int k, Stack<Integer> stack, ArrayList<ArrayList<Integer>> res) {
        int n = S.length;
        if(k == n) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        dfs(S,k+1,stack,res);
        stack.push(S[k]);
        dfs(S,k+1,stack,res);
        stack.pop();
    }
}
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        dfs(candidates,0,target,stack,res);
        return res;
    }

    void dfs(int[] num, int k, int t, Stack<Integer> stack, ArrayList<ArrayList<Integer>> res) {
        if(t < 0)   return;
        if(t == 0) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        for(int i=k; i<num.length; i++) {
            stack.push(num[i]);
            dfs(num,i,t-num[i],stack,res);
            stack.pop();
        }
    }
}
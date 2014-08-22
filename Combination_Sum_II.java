public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        dfs(candidates,0,target,stack,res);
        return res;
    }

    void dfs(int[] num, int k, int t, Stack<Integer> s, ArrayList<ArrayList<Integer>> res) {
        if(t < 0 )  return;
        if(t == 0) {
            res.add(new ArrayList<Integer>(s));
            return;
        }
        int n = num.length;
        int cur = 0;
        for (int i=k; i<n; i++) {
            if(i != k && num[i] == cur) continue;
            cur = num[i];
            s.push(cur);
            dfs(num,i+1,t-cur,s,res);
            s.pop();
        }
    }
}
// Recursive
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
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
        if(stack.empty() || stack.peek() != S[k])
            dfs(S,k+1,stack,res);
        stack.push(S[k]);
        dfs(S,k+1,stack,res);
        stack.pop();
    }
}

// Iteration
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        int n = S.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(S);
        int start = 0;
        for(int i=0; i<n; i++) {
            int size = res.size();
            for(int j=start; j<size; j++) {
                ArrayList<Integer> nw = new ArrayList<Integer>(res.get(j));
                nw.add(S[i]);
                res.add(nw);
            }
            start = (i<n-1 && S[i+1] == S[i]) ? size : 0;
        }  
        return res;
    }
}
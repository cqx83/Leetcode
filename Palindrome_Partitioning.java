public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        for(int i=0; i<n; i++)  Arrays.fill(p[i],false);
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<2 || p[i+1][j-1]))
                    p[i][j] = true;
            }
        }
        Stack<String> stack = new Stack<String>();
        dfs(s,0,stack,p,res);
        return res;
    }

    void dfs(String s, int k, Stack<String> stack, boolean[][] p, 
                ArrayList<ArrayList<String>> res) {
        if(k == s.length()) {
            res.add(new ArrayList<String>(stack));
            return;
        }
        for(int i=k; i<s.length(); i++) {
            if(p[k][i]) {
                stack.push(s.substring(k,i+1));
                dfs(s,i+1,stack,p,res);
                stack.pop();
            }
        }
    }
}
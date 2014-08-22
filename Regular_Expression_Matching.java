public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int[][] dp = new int[m+1][n+1];
        // -1 undefine, 0 false, 1 true
        for (int i=0; i<=m; i++) Arrays.fill(dp[i],-1);
        dfs(s.toCharArray(),0,p.toCharArray(),0,dp);
        return dp[0][0] == 1;   
    }

    public int dfs(char[] s, int x, char[] p, int y, int[][] dp) {
        if(dp[x][y] != -1)  return dp[x][y];
        int m = s.length, n = p.length;
        int res = -1;
        if(y == n) {
            res = m == x ? 1 : 0;
            dp[x][y] = res;
            return res;
        }
        char c = p[y];
        if(y == n-1 || p[y+1] != '*') {
            if(x == m || (c != s[x] && c != '.')) {
                res = 0;
            } else {
                res = dfs(s,x+1,p,y+1,dp);
            }
        } else {
            for (int i=0; x+i<m && (c == s[x+i] || c == '.'); i++) {
                if(dfs(s,x+1+i,p,y+2,dp) == 1)
                    res = 1;
            }
            res = res == 1 ? 1 : dfs(s,x,p,y+2,dp);
        }
        dp[x][y] = res;
        return res;
    }
}
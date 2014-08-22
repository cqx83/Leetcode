public class Solution {
    public int numDistinct(String S, String T) {
        int n = S.length(), m = T.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
            dp[i][0] = 0;
        for(int j=0; j<=n; j++)
            dp[0][j] = 1;
        dp[0][0] = 1;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(S.charAt(j-1) == T.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
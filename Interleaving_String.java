public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	int m = s1.length(), n = s2.length(), l = s3.length();
    	if(m + n != l)	return false;
    	boolean[][] dp = new boolean[m+1][n+1];
    	dp[0][0] = true;
    	for(int i=1; i<=m; i++)
    		dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
    	for(int j=1; j<=n; j++)
    		dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
    	for(int i=1; i<=m; i++) {
    		for (int j=1; j<=n; j++) {
    			char c1 = s1.charAt(i-1), c2 = s2.charAt(j-1), c3 = s3.charAt(i+j-1);
    			dp[i][j] = (c1 == c3 && dp[i-1][j]) || (c2 == c3 && dp[i][j-1]);
    		}
    	}
    	return dp[m][n];
    }
}
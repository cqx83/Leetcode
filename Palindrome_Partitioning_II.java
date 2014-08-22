public class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[][] isP = new boolean[n][n];
        for(int i=0; i<n; i++)  Arrays.fill(isP[i],false);
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++) dp[i] = n-i;
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
            	if(arr[i] == arr[j] && (j-i<2 || isP[i+1][j-1])) {
            		isP[i][j] = true;
            		dp[i] = Math.min(dp[i], dp[j+1]+1);
            	}
            }
        }
        return dp[0]-1;
    }
}
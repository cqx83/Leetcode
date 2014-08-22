public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), max = 0;
        String longest = "";
        char[] sa = s.toCharArray();
        boolean dp[][] = new boolean[n][n];
        for(int i=0; i<n; i++)  Arrays.fill(dp[i],false);
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(sa[i]==sa[j] && (j-i<2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(j-i+1 > max) {
                        max = j-i+1;
                        longest = s.substring(i,j+1);
                    }
                }
            }
        }
        return longest;
    }
}
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean dp[] = new boolean[n];
        Arrays.fill(dp, false);
        for(int i=0; i<n; i++) {
        	if(dict.contains(s.substring(0, i+1))) {
        		dp[i] = true;
        		continue;
        	}
    		for(int j=i; j>0; j--) {
    			if(dict.contains(s.substring(j,i+1)) && dp[j-1]) {
    				dp[i] = true;
    				break;
    			}
    		}
        }
        return dp[n-1];
    }
}
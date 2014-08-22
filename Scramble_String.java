// DP
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())  return false;
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n+1];
        // initialization
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
        
        // [i,i+l) [j.j+l)  [i,i+k)~[i+k,i+l) [i][k]~[i+k][l-k]
        // 1<=k<l
        // dp[i][j][l] = dp[i][j][k] && dp[i+k][j+k][l-k] || dp[i][j+l-k][k] && dp[i+k][j][l-k]
        
        for(int l=2; l<=n; l++) {
            for(int i=0; i<=n-l; i++) {
                for(int j=0; j<=n-l; j++) {
                    for(int k=1; k<l; k++) {
                        dp[i][j][l] = false;
                        if((dp[i][j][k] && dp[i+k][j+k][l-k]) || (dp[i][j+l-k][k] && dp[i+k][j][l-k])) {
                            dp[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}

// DFS
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())  return false;
        int n = s1.length();
        if(n == 0)    return true;
        if(s1.equals(s2))   return true;
        if(!check(s1,s2))   return false;
        for(int i=0; i<n-1; i++) {
            if(isScramble(s1.substring(0,i+1),s2.substring(0,i+1)) &&
                isScramble(s1.substring(i+1,n),s2.substring(i+1,n)))
                return true;
            if(isScramble(s1.substring(0,i+1),s2.substring(n-i-1,n)) &&
                isScramble(s1.substring(i+1,n),s2.substring(0,n-i-1)))
                return true;
        }
        return false;
    }
    
    boolean check(String s1, String s2) {
        int[] bucket = new int[256];
        Arrays.fill(bucket,0);
        for(int i=0; i<s1.length(); i++) {
            bucket[s1.charAt(i)]++;
            bucket[s2.charAt(i)]--;
        }
        for(int i=0; i<256; i++)
            if(bucket[i] != 0)
                return false;
        return true;
    }
}
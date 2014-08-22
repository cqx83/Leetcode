public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean dp[] = new boolean[n];
        for(int i=n-1; i>=0; i--) {
            dp[i] = dict.contains(s.substring(i,n));
        }
        for(int i=n-1; i>=0; i--) {
            if(dp[i] == true)   continue;
            for(int j=i; j<n-1; j++) {
                if(dp[j+1] && dict.contains(s.substring(i,j+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        ArrayList<String> res = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        dfs(s,0,dict,stack,res,dp);
        return res;
    }

    void dfs(String s, int k, Set<String> dict, Stack<String> stack, ArrayList<String> res,boolean[] dp) {
        int n = s.length();
        if(k == n) {
            res.add(convert(stack));
            return;
        }
        if(!dp[k])  return;
        for(int i=k; i<n; i++) {
            String sub = s.substring(k,i+1);
            if(dict.contains(sub)) {
                stack.push(sub);
                dfs(s,i+1,dict,stack,res,dp);
                stack.pop();
            }
        }
    }
    
    String convert(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        for(String s : stack)
            sb.append(s+" ");
        return sb.substring(0,sb.length()-1);
    }
}
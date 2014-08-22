public class Solution {
    public int atoi(String str) {
    	int n = str.length();
    	if(str.length() == 0)	return 0;
        char[] s = str.toCharArray();
        int i=0, res = 0, sign = 1;
        while(i<n && s[i] == ' ')
        	i++;
        if(i == n)	return 0;
        if(s[i]!='-' && s[i]!='+' && !check(s[i]))
        	return 0;
        if(s[i] == '-' || s[i] == '+') {
        	if(s[i] == '-')	sign = -1;
        	i++;
        }
        for(;i<n && check(s[i]); i++) {
        	if(res > Integer.MAX_VALUE/10 || 
        			(res == Integer.MAX_VALUE/10 && (s[i]-'0') > Integer.MAX_VALUE%10)) {
        		return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        	}
        	res = res*10 + (s[i]-'0');
        }
        res *= sign;
        return res;
    }

    boolean check(char c) {
    	return ('0'<=c && c<='9');
    }
}
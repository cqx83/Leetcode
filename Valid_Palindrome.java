public class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toLowerCase().toCharArray();
        int n = str.length;
        if(n == 0)	return true;
        int l=0, r=n-1;
        while(l<r) {
        	while(l<n && !check(str[l]))
        		l++;
        	while(r>=0 && !check(str[r]))
        		r--;
        	if(l<r && str[l] != str[r])
        		return false;
        	l++;
        	r--;
        }
        return true;
    }
    
    public boolean check(char c) {
    	if(c >= 'a' && c <= 'z')
    	    return true;
    	if(c >= '0' && c <= '9')
    	    return true;
    	return false;
    }
}
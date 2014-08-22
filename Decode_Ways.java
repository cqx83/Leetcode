public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0)	return 0;
        int fn_1 = check(s.charAt(n-1)) ? 1 : 0, fn_2 = 1, fn = 0;
        if(n == 1)	return fn_1;
        for(int i=n-2; i>=0; i--) {
        	fn = (check(s.charAt(i)) ? fn_1 : 0) + 
        			(check(s.charAt(i),s.charAt(i+1)) ? fn_2 : 0);
        	fn_2 = fn_1;
        	fn_1 = fn;
        }
        return fn;
    }

    public boolean check(char c) {
    	return ('1' <= c && c <= '9');
    }

    public boolean check(char a, char b) {
    	if(a == '1')	return true;
    	return (a == '2' && '0' <= b && b <= '6');
    }
}
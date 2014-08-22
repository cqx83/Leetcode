public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
    	ArrayList<String> res = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        helper(s,0,4,stack,res);
        return res;
    }
    
    public void helper(String s, int k, int m, Stack<String> stack, ArrayList<String> res) {
    	if(m == 0 && k == s.length()) {
    		String nw = "";
    		for(String iter : stack)
    			nw += iter + ".";
    		res.add(nw.substring(0,nw.length()-1));
    		return;
    	}
    	else if(m == 0 || k == s.length())
    		return;
    	int n = s.length() - k;
    	if(n < m || n > m*3)	return;
    	for(int i=k; i<Math.min(k+3, s.length()); i++) {
    		if(check(s.substring(k,i+1))) {
    			stack.push(s.substring(k,i+1));
    			helper(s,i+1,m-1,stack,res);
    			stack.pop();
    		}
    	}
    }
    
    public boolean check(String s) {
    	if(s.charAt(0) == '0' && s.length()>1)	return false;
    	int sum = 0;
    	for(int i=0; i<s.length(); i++) {
    		sum = sum*10 + s.charAt(i)-'0';
    	}
    	if(sum > 255)	return false;
    	return true;
    }
}
public class Solution {
    public boolean isMatch(String s, String p) {
    	int si = 0, pi = 0, sn = s.length(), pn = p.length();
    	char[] sa = s.toCharArray(), pa = p.toCharArray();
    	int star = -1, retry = -1;
    	while(si < sn) {
    		if(pi == pn) {
    			if(star == -1)	return false;
    			si = retry++;
    			pi = star+1;
    		} else if(sa[si] == pa[pi] || pa[pi] == '?') {
    			si++;
    			pi++;
    		} else if(pa[pi] == '*') {
    			star = pi;
    			retry = si+1;
    			pi++;
    		} else if(star != -1) {
    			si = retry++;
    			pi = star + 1;
    		} else {
    			return false;
    		}
    	}
    	
    	for(int i=pi; i<pn; i++) {
    		if(pa[i] != '*')	return false;
    	}
    	return true;
   	}
}
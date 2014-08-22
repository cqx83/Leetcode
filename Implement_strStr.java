public class Solution {
    public String strStr(String a, String b) {
    	int al = a.length(), bl = b.length();
    	for(int i=0; i<=al-bl; i++) {
    		int j = 0;
    		for(; j<bl; j++) {
    			if(a.charAt(i+j) != b.charAt(j))
    				break;
    		}
    		if(j == bl)	return a.substring(i);
    	}
    	return null;
    }
}
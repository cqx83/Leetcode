public class Solution {
    public String addBinary(String a, String b) {
    	char[] aa = a.toCharArray(), ba = b.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	boolean carry = false;
    	for(int ai = aa.length-1, bi = ba.length-1; ai >=0 || bi >=0 || carry; ai--, bi--) {
    		int sum = (ai >= 0 ? aa[ai]-'0' : 0) + (bi >= 0 ? ba[bi]-'0' : 0) + (carry ? 1 : 0);
    		carry = sum > 1;
    		sb.insert(0,(char)(sum%2+'0'));
    	}
    	return sb.toString();
    }
}
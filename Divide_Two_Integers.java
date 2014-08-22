public class Solution {
    public int divide(int dividend, int divisor) {
    	int res = 0, m = 0;
    	boolean sign = (dividend > 0) == (divisor > 0);
    	long a = Math.abs((long)dividend), b = Math.abs((long)(divisor));
    	while(a >= b) {
    		long c = b<<m;
    		if(a >= c) {
    			a -= c;
    			res += 1<<m;
    			m++;
    		} else {
    			m--;
    		}
    	}
    	return sign ? res : -res;
    }
}
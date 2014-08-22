public class Solution {
    public int maxProfit(int[] prices) {
    	int n = prices.length, mp = 0;
    	if(n == 0)	return 0;
    	int[] res = new int[n];
    	int low = prices[0], high = prices[n-1];
    	for(int i=0; i<n; i++) {
    		res[i] = prices[i]-low;
    		low = Math.min(low, prices[i]);
    	}
    	int right = 0;
    	for(int i=n-1; i>=0; i--) {
    		right = Math.max(right, high - prices[i]);
    		mp = Math.max(mp,res[i] + right);
    		high = Math.max(high, prices[i]);
    	}
    	return mp;
    }
}
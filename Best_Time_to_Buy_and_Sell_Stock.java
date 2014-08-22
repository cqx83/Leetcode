public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = prices.length;
        if(len <= 1)
            return 0;
        int p = 0, low = prices[0];
        for(int i=1; i<len; i++) {
            p = Math.max(p,prices[i]-low);
            low = Math.min(prices[i],low);
        }
        return p;
    }
}
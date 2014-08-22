public class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];
        candies[0] = 1;
        for(int i=1; i<n; i++) {
        	candies[i] = (ratings[i] > ratings[i-1]) ? candies[i-1]+1 : 1;
        }
        int res = candies[n-1];
        for(int i=n-2; i>=0; i--) {
        	if(ratings[i]>ratings[i+1] && !(candies[i]>candies[i+1]))
        		candies[i] = candies[i+1]+1;
        	res += candies[i];
        }
        return res;
    }
}
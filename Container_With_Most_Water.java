public class Solution {
    public int maxArea(int[] height) {
        int n = height.length, max = 0;
        int l = 0, r = n-1;
        while(l < r) {
            max = Math.max(max,(r-l)*Math.min(height[l],height[r]));
            if(height[l] <= height[r])  l++;
            else r--;
        }
        return max;
    }
}
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<Integer> dp = new ArrayList<Integer>();
        if(triangle.size() == 0)    return Integer.MAX_VALUE;
        dp.add(triangle.get(0).get(0));
        for(int i=1; i<triangle.size(); i++) {
            ArrayList<Integer> cur = triangle.get(i);
            int size = cur.size();
            dp.add(dp.get(size-2) + cur.get(size-1));
            for(int j=size-2; j>=1; j--) {
                dp.set(j,Math.min(dp.get(j-1),dp.get(j))+cur.get(j));
            }
            dp.set(0,dp.get(0)+cur.get(0));
        }
        int min = Integer.MAX_VALUE;
        for(int i : dp) min = Math.min(i,min);
        return min;
    }
}
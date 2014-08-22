public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for(int i=0;i <n; i++) {
            int k = 1<<i;
            for(int j=k-1; j>=0; j--) {
                res.add(res.get(j)+k);
            }
        }
        return res;
    }
}
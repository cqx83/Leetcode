public class Solution {
    public int singleNumber(int[] A) {
        int c = 0;
        for (int i=0; i<A.length; i++) {
            c ^= A[i];
        }
        return c;
    }
}
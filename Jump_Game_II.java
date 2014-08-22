public class Solution {
    public int jump(int[] A) {
        int n = A.length, cr = 0, nr = 0, step = 0;
        for(int i=0; i<n; i++) {
            if(i > cr) {
                step++;
                cr = nr;
                if(i > nr)  return -1;
                if(nr >= n-1)   return step;
            }
            nr = Math.max(nr,A[i] + i);
        }
        return step;   
    }
}
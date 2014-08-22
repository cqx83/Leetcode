public class Solution {
    public boolean canJump(int[] A) {
        int n = A.length, range = 0;
        for(int i=0; i<n; i++) {
            if(range < i)   return false;
            range = Math.max(A[i]+i,range);
            if(range >= n-1)    return true;
        }
        return true;
    }
}
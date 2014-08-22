public class Solution {
    public int trap(int[] A) {
        int n = A.length, res = 0;
        int[] buf = new int[n];
        for(int i=0, h=0; i<n; i++) {
            buf[i] = h-A[i] > 0 ? (h-A[i]) : 0;
            h = Math.max(h,A[i]);
        }
        for(int i=n-1, h=0; i>=0; i--) {
            buf[i] = Math.min(buf[i],h-A[i]>0 ? (h-A[i]) : 0);
            res += buf[i];
            h = Math.max(h,A[i]);
        }
        return res;
    }
}
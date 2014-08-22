public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = search(A,target,true);
        res[1] = search(A,target,false);
        return res;
    }

    int search(int[] A, int t, boolean left) {
        int l = 0, r = A.length-1, res = -1;
        while(l <= r) {
            int mid = l+(r-l)/2;
            if(A[mid] == t) {
                res = mid;
                if(left)    r = mid-1;
                else        l = mid+1;
            } else if(A[mid] < t) {
                l = mid+1;
            } else if(A[mid] > t) {
                r = mid-1;
            }
        }
        return res;
    }
}
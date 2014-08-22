public class Solution {
    public boolean search(int[] A, int target) {
        int n = A.length, l = 0, r = n-1;
        while(l <= r) {
            int mid = l+(r-l)/2;
            if(A[mid] == target)    return true;
            if(A[l] < A[mid]) {
                if(A[l] <= target && target <= A[mid])  r = mid - 1;
                else l = mid + 1;
            } else if(A[l] > A[mid]) {
                if(A[mid] <= target && target <= A[r])  l = mid + 1;
                else r = mid - 1;
            } else {
                l++;
            }
        }
        return false;
    }
}
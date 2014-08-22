public class Solution {
    public void sortColors(int[] A) {
        int n = A.length, l = 0, r = n-1;
        for(int i=0; i<=r ;i++) {
            if(A[i] == 0) {
                swap(A,i,l);
                l++;
            } else if(A[i] == 2) {
                swap(A,i,r);
                r--;
                i--;
            }
        }
    }

    void swap(int[] A, int x, int y) {
        int t = A[x];
        A[x] = A[y];
        A[y] = t;
    }   
}
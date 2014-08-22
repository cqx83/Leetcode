public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length, len = -1;
        if(n == 0)  return 0;
        for(int i=0; i<n; i++) {
            if(i == 0 || A[i] != A[len]) {
                A[++len] = A[i];
            }
        }
        return len+1;
    }
}
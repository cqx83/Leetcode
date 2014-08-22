public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length, len = -1, c = 2-1, comp = 0;
        for(int i=0; i<n; i++) {
            if(i == 0 || A[i] != A[len]) {
                comp = A[i];
                A[++len] = A[i];
                c = 2-1;
            } else if(c > 0) {
                A[++len] = comp;
                c--;
            }
        }
        return len+1;   
    }
}
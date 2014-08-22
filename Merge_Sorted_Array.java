public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int k = m+n-1, a = m-1, b = n-1;
        while(b >= 0 && a >= 0) A[k--] = A[a] >= B[b] ? A[a--] : B[b--];
        while(b >= 0) A[k--] = B[b--];
    }
}
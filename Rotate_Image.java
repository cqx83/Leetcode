public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0)  return;
        for (int level = 0; level<n/2; level++) {
            int f = level, l = n-1-level;
            for (int i=f; i<l; i++) {
                int offset = i-f;
                int t = matrix[f][i];
                matrix[f][i] = matrix[l-offset][f];
                matrix[l-offset][f] = matrix[l][l-offset];
                matrix[l][l-offset] = matrix[i][l];
                matrix[i][l] = t;
            }
        }
    }
}
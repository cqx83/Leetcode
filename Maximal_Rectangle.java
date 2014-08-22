public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, res = 0;
        if(m == 0)  return 0;
        int n = matrix[0].length;
        int[] l = new int[n];Arrays.fill(l,-1);
        int[] r = new int[n];Arrays.fill(r,n);
        int[] h = new int[n];Arrays.fill(h,0);
        for (int i=0; i<m; i++) {
            int left = -1;
            for (int j=0; j<n; j++) {
                if(matrix[i][j] == '1') {
                    h[j]++;
                    l[j] = Math.max(l[j],left);
                } else {
                    h[j] = 0;
                    l[j] = -1;
                    left = j;
                }
            }
            int right = n;
            for (int j=n-1; j>=0; j--) {
                if(matrix[i][j] == '1') {
                    r[j] = Math.min(r[j],right);
                    res = Math.max(res,(r[j]-l[j]-1)*h[j]);
                } else {
                    right = j;
                    r[j] = n;
                }
            }
        }
        return res;
    }
}
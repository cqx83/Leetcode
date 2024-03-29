public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)  return;
        int n = matrix[0].length;
        
        boolean rowZero = false, colZero = false;
        for(int j=0; j<n; j++)
            if(matrix[0][j] == 0)
                rowZero = true;
        for(int i=0; i<m; i++)
            if(matrix[i][0] == 0)
                colZero = true;
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(rowZero)
            Arrays.fill(matrix[0],0);
        if(colZero) {
            for(int i=0; i<m; i++)
                matrix[i][0] = 0;
        }
    }
}
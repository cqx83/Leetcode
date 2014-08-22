public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        boolean[][] row = new boolean[n][n];
        boolean[][] col = new boolean[n][n];
        boolean[][] box = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == '.')  continue;
                int num = board[i][j] - '1';
                if(row[i][num] || col[j][num] || box[i/3*3+j/3][num])   return false;
                row[i][num] = col[j][num] = box[i/3*3+j/3][num] = true;
            }
        }
        return true;
    }
}
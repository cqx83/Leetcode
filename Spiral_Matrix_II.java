public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0, y = -1, k = 1;
        for (int i=n; i>0; i-=2) {
            for(int j=0; j<i; j++)      res[x][++y] = k++;
            for(int j=0; j<i-1; j++)    res[++x][y] = k++;
            for(int j=0; j<i-1; j++)    res[x][--y] = k++;
            for(int j=0; j<i-2; j++)    res[--x][y] = k++;
        }
        return res;
    }
}
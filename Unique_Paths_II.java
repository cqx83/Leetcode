public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] grid = obstacleGrid;
        int m = obstacleGrid.length;
        if(m == 0)  return 0;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(grid[m-1][n-1] == 1) return 0;
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) {
                    dp[i][j] = 1;
                } else if(grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = get(dp,i+1,j) + get(dp,i,j+1);
                }
            }
        }
        return dp[0][0];
    }

    int get(int[][] dp, int x, int y) {
        int m = dp.length, n = dp[0].length;
        if(x >= m || y >= n)    return 0;
        return dp[x][y];
    }
}
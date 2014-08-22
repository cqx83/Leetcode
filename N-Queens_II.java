public class Solution {
    public int totalNQueens(int n) {
        int[] queen = new int[n];
        Arrays.fill(queen,-1);
        return dfs(queen,0);
    }

    int dfs(int[] queen, int k) {
        int n = queen.length, count = 0;
        if(k == n)  return 1;
        for(int i=0; i<n; i++) {
            if(check(queen,k,i)) {
                queen[k] = i;
                count += dfs(queen,k+1);
                queen[k] = -1;
            }
        }
        return count;
    }

    boolean check(int[] queen, int x, int y) {
        int n = queen.length;
        for(int i=0; i<x; i++) {
            if(y == queen[i] || x-i == Math.abs(y-queen[i]))
                return false;
        }
        return true;
    }
}
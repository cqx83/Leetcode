// ugly
public class Solution {
	public boolean exist(char[][] board, String word) {
	    int m = board.length;
	    if(m == 0)	return false;
	    int n = board[0].length;
	    if(word.length() == 0)	return true;
	    boolean[][] visit = new boolean[m][n];
	    for(int i=0; i<m; i++)
	       Arrays.fill(visit[i], false);
	   for(int i=0; i<m; i++) {
	       for(int j=0; j<n; j++) {
	          if(board[i][j] == word.charAt(0)) {
	        	 visit[i][j] = true;
	             if(helper(board, visit, word.substring(1), i, j, m, n)) {
	                return true;
	            }
	             visit[i][j] = false;
	          }
	       }
	   }
	    return false;
	}

	public boolean helper(char[][] board, boolean[][] map, String word, int x, int y, int m, int n) {
	    if(word.length() == 0)    return true;
	    if(x<m-1 && !map[x+1][y] && board[x+1][y] == word.charAt(0)) {
	        map[x+1][y] = true;
	        if(helper(board,map,word.substring(1),x+1,y,m,n))
	            return true;
	        map[x+1][y] = false;
	    }
	    if(y<n-1 && !map[x][y+1] && board[x][y+1] == word.charAt(0)) {
	        map[x][y+1] = true;
	        if(helper(board,map,word.substring(1),x,y+1,m,n))
	            return true;
	        map[x][y+1] = false;
	    }
	    if(x>0 && !map[x-1][y] && board[x-1][y] == word.charAt(0)) {
	        map[x-1][y] = true;
	        if(helper(board,map,word.substring(1),x-1,y,m,n))
	            return true;
	        map[x-1][y] = false;
	    }
	    if(y>0 && !map[x][y-1] && board[x][y-1] == word.charAt(0)) {
	        map[x][y-1] = true;
	        if(helper(board,map,word.substring(1),x,y-1,m,n))
	            return true;
	        map[x][y-1] = false;
	    }
	    return false;
	}
}
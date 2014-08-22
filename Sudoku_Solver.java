public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board,0);
    }
    
    public boolean dfs(char[][] board, int k) {
    	if(k == 81)	return true;
    	
    	int cx = k/9, cy = k%9;
    	if(board[cx][cy] != '.')
    		return dfs(board,k+1);
    	for(char i='1'; i<='9'; i++) {
    		if(check(board,cx,cy,i)) {
    			board[cx][cy] = i;
    			if(dfs(board,k+1))
    				return true;
    			board[cx][cy] = '.';
    		}
    	}
    	return false;
    }
    
    boolean check(char[][] board, int x, int y, char v) {
    	for(int i=0; i<9; i++)
    		if(board[i][y] == v)
    			return false;
    	for(int j=0; j<9; j++)
    		if(board[x][j] == v)
    			return false;
    	int boxX = x/3*3, boxY = y/3*3;
    	for(int i=0; i<3; i++) {
    		for(int j=0; j<3; j++) {
    			if(board[boxX+i][boxY+j] == v)
    				return false;
    		}
    	}
    	return true;
    }
}
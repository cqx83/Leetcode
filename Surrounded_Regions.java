public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0)  return;
        int n = board[0].length;

        for(int i=0; i<m ;i++) {
            if(board[i][0] == 'O')
                bfs(board,i,0,m,n);
            if(board[i][n-1] == 'O')
                bfs(board,i,n-1,m,n);
        }
        for(int j=0; j<n ;j++) {
            if(board[0][j] == 'O')
                bfs(board,0,j,m,n);
            if(board[m-1][j] == 'O')
                bfs(board,m-1,j,m,n);
        }

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                board[i][j] = (board[i][j] == '-' ? 'O' : 'X');
        return;
    }

    public void bfs(char[][] board, int i, int j, int m, int n) {
        board[i][j] = '-';
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i*n+j);
        while(queue.size()>0) {
            int cur = queue.poll();
            int x = cur/n, y = cur%n;
            if(x+1<m && board[x+1][y] == 'O')   {board[x+1][y]='-';queue.add((x+1)*n+y);}
            if(y+1<n && board[x][y+1] == 'O')   {board[x][y+1]='-';queue.add((x)*n+y+1);}
            if(x-1>=0 && board[x-1][y] == 'O')  {board[x-1][y]='-';queue.add((x-1)*n+y);}
            if(y-1>=0 && board[x][y-1] == 'O')  {board[x][y-1]='-';queue.add((x)*n+y-1);}
        }
    }
}
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	int m = matrix.length;
        if(m == 0)	return res;
        int n = matrix[0].length;
        int x = 0, y = -1;
        while(n > 0) {
        	for(int i=0; i<n; i++)
        		res.add(matrix[x][++y]);
        	if(m-1 <= 0)	break;
        	for(int i=0; i<m-1; i++)
        		res.add(matrix[++x][y]);
        	if(n-1 <= 0)	break;
        	for(int i=0; i<n-1; i++)
        		res.add(matrix[x][--y]);
        	if(m-2 <= 0)	break;
        	for(int i=0; i<m-2; i++)
        		res.add(matrix[--x][y]);
        	m -= 2;
        	n -= 2;
        }
        return res;
    }
}
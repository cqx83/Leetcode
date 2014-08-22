public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> res = new ArrayList<String[]>();
    	int[] q = new int[n];
    	Arrays.fill(q, -1);
    	dfs(q, 0, n, res);
    	return res;
    }
    
    public void dfs(int[] q, int k, int n, ArrayList<String[]> res) {
    	if(n == k) {
    		res.add(convert(q));
    		return;
    	}
		for(int j=0; j<n; j++) {
			if(check(q,k,j)) {
				q[k] = j;
				dfs(q,k+1,n,res);
				q[k] = -1;
			}
		}
    }
    
    public boolean check(int[] q, int k, int v) {
    	for(int i=0; i<k; i++) {
    		if(q[i] == v)	return false;
    		if(Math.abs(q[i] - v) == (k-i))	return false;
    	}
    	return true;
    }
    
    public String[] convert(int[] q) {
    	int n = q.length;
    	char[][] buffer = new char[n][n];
    	for(int i=0; i<n; i++)
    		Arrays.fill(buffer[i], '.');
    	for(int i=0; i<n; i++) {
    		buffer[i][q[i]] = 'Q';
    	}
    	String[] res = new String[n];
    	for(int i=0; i<n; i++) {
    		StringBuilder sb = new StringBuilder();
    		sb.append(buffer[i]);
    		res[i] = sb.toString();
    	}
    	return res;	
    }
}
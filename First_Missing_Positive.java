public class Solution {
    public int firstMissingPositive(int[] A) {
    	int n = A.length;
    	for(int i=0; i<n; i++) {
    		int v = A[i];
    		if(v <= 0 || v > n || A[v-1] == v)	continue;
    		swap(A,i,v-1);
    		i--;
    	}
    	int res = n+1;
    	for(int i=0; i<n; i++) {
    		if(A[i] != i+1)
    			return i+1;
    	}
    	return res;
    }
    
    void swap(int[] num, int x, int y) {
    	int t = num[x];
    	num[x] = num[y];
    	num[y] = t;
    }
}
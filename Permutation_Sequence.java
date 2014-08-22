public class Solution {
    public String getPermutation(int n, int k) {
    	if(n == 0)	return "";
    	k--;
    	int[] fc = new int[n+1]; 
    	List<Integer> list = new ArrayList<Integer>();
    	fc[0] = 1;
    	for(int i=1; i<=n; i++) {
    		fc[i] = i*fc[i-1];
    		list.add(i);
    	}
    	StringBuilder sb = new StringBuilder();
    	while(--n >=0 ) {
    		int t = k/fc[n];
    		sb.append((char)(list.get(t)+'0'));
    		list.remove(t);
    		k = k%fc[n];
    	}
    	return sb.toString();
    }
}
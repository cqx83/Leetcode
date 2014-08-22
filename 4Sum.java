public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	int n = num.length;
    	if(n == 0)	return res;
    	Arrays.sort(num);
    	int l = 0, r = n-1;
    	
    	for(int i=0; i<n; i++) {
    	    if(i != 0 && num[i] == num[i-1])    continue;
    		for(int j=n-1; j-i>2; j--) {
    		    if(j != n-1 && num[j] == num[j+1])  continue;
    			ArrayList<ArrayList<Integer>> sub = helper(num,target-num[i]-num[j],i+1,j-1);
    			for(ArrayList<Integer> iter : sub) {
    				iter.add(0,num[i]);res.add(iter);iter.add(num[j]);
    			}
    		}
    	}
    	return res;
    }
    
    public ArrayList<ArrayList<Integer>> helper(int[] num, int target, int l, int r) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	int start = l, end = r;
    	while(l < r) {
    	    if(l != start && num[l] == num[l-1])    l++;
    	    else if(r != end && num[r] == num[r+1])  r--;
    	    else if(num[l] + num[r] < target)   l++;
    	    else if(num[l] + num[r] > target)   r--;
    	    else {
    			ArrayList<Integer> nw = new ArrayList<Integer>();
    			nw.add(num[l]);nw.add(num[r]);
    			res.add(nw);
    			l++;r--;
    	    }
    	}
    	return res;
    }
}
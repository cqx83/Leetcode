public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int n = num.length;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<n-2; i++) {
        	helper(num,i+1,num[i],res);
        	while(i<n-2 && num[i+1] == num[i])
        		i++;
        }
        return res;
    }

    public void helper(int[] num, int k, int t, ArrayList<ArrayList<Integer>> res) {
    	int l = k, r = num.length-1;
    	while(l < r) {
    		int sum = num[l] + num[r] + t;
    		boolean lMove = false, rMove = false;
    		if(sum == 0) {
    			ArrayList<Integer> nw = new ArrayList<Integer>();
    			nw.add(t);	nw.add(num[l]);	nw.add(num[r]);
    			res.add(nw);
    			lMove = true;
    			rMove = true;
    		}
    		else if(sum < 0) {
    			lMove = true;
    		}
    		else {
    			rMove = true;
    		}

    		if(lMove) {
    			while(l < r && num[l+1] == num[l])
    				l++;
    			l++;
    		}
    		if(rMove) {
    			while(l < r && num[r-1] == num[r])
    				r--;
    			r--;
    		}
    	}
    }
}
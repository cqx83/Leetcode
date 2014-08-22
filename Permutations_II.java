public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        dfs(num,0,res);
        return res;
    }

    void dfs(int[] num, int k, ArrayList<ArrayList<Integer>> res) {
        int n = num.length;
        if(k == n) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<num.length; i++)
                list.add(num[i]);
            res.add(list);
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i=k; i<n; i++) {
            if(set.add(num[i])) {
                swap(num,i,k);
                dfs(num,k+1,res);
                swap(num,i,k);
            }
        }
    }

    void swap(int[] num, int l, int r) {
        int tmp = num[l];
        num[l] = num[r];
        num[r] = tmp;       
    }
}
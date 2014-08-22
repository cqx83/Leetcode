public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows < 0) return res;
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        for(int i=0; i<numRows; i++) {
            ArrayList<Integer> next = new ArrayList<Integer>();
            next.add(1);
            for(int j=0; j<cur.size()-1; j++)
                next.add(cur.get(j)+cur.get(j+1));
            next.add(1);
            res.add(cur);
            cur = next;
        }
        return res;
    }
}
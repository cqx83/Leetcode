public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0)    return res;
        for(int i=0; i<=rowIndex; i++) {
            int size = res.size();
            res.add(1);
            for(int j=size-1; j>=1; j--)
                res.set(j,res.get(j)+res.get(j-1));
        }
        return res;
    }
}
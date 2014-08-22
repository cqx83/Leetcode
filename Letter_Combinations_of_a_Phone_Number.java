public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for(int i=0; i<digits.length(); i++) {
            char key = digits.charAt(i);
            int size = res.size();
            String cd = map[(key-'0')-2];
            for(int j=0; j<size; j++) {
                for(int k=0; k<cd.length(); k++) {
                    char nw = cd.charAt(k);
                    if(k == cd.length()-1) {
                        res.set(j,res.get(j)+nw);
                    } else {
                        res.add(res.get(j)+nw);
                    }
                }
            }
        }
        return res;
    }
}
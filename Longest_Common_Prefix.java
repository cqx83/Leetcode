public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)    return "";
        String base = strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<base.length() ; i++) {
            char c = base.charAt(i);
            for (int j=1; j<strs.length; j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != c)
                    return base.substring(0,i);
            }
        }
        return base;
    }
}
public class Solution {
    public String reverseWords(String s) {
        ArrayList<String> buf = new ArrayList<String>();
        s += ' ';
        int n = s.length(), h = -1;
        for(int i=0; i<n; i++) {
            if(h == -1 && s.charAt(i) != ' ')   h = i;
            else if(h != -1 && s.charAt(i) == ' ') {
                buf.add(0,s.substring(h,i));
                h = -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String iter : buf)  sb.append(iter+" ");
        return sb.length() == 0 ? "" : sb.substring(0,sb.length()-1).toString();
    }
}
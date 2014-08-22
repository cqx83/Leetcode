public class Solution {
    public String convert(String s, int nRows) {
        StringBuilder sb = new StringBuilder();
        char[] sa = s.toCharArray();
        int diff = 2*nRows-2, n = s.length();
        if(nRows <= 1)  return s;
        for(int i=0; i<nRows; i++) {
            int j = i;
            while(j < n) {
                sb.append(sa[j]);
                j += diff;
                if(i != 0 && i != nRows-1 && j-2*i < n)
                    sb.append(sa[j-2*i]);
            }
        }
        return sb.toString();
    }
}
public class Solution {
    public String minWindow(String S, String T) {
        char[] sa = S.toCharArray(), ta = T.toCharArray();
        int[] base = new int[256], ref = new int[256];
        int charCount = 0;
        Arrays.fill(base,0);Arrays.fill(ref,0);
        for(char c : ta) {
            if(base[c] == 0)    charCount++;
            base[c]++;
        }
        int count = 0, min = Integer.MAX_VALUE, lm = 0, rm = -1, l = 0;
        for(int r=0; r<sa.length; r++) {
            char c = sa[r];
            if(base[c] == 0)    continue;
            if(++ref[c] == base[c]) count++;
            if(count == charCount) {
                for(;l<=r;l++) {
                    if(base[sa[l]] != 0) {
                        if(--ref[sa[l]] < base[sa[l]])   break;
                    }
                }
                if(r-l+1 < min) {min=r-l+1;lm=l;rm=r;}
                l++;count--;
            }
        }
        return S.substring(lm,rm+1);
    }
}
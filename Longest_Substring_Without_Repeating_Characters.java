public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, max = 0;
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(!set.add(c)) {
                max = Math.max(max,i-l);
                while(s.charAt(l) != c) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
        }
        max = Math.max(max,n-l);
        return max;
    }
}
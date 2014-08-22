public class Solution {
    public String countAndSay(int n) {
        if(n <= 0)  return "";
        String res = "1";
        for(int i=2; i<=n; i++) {
            StringBuilder sb = new StringBuilder();
            char cur = res.charAt(0);
            int count = 1;
            for(int j=1; j<res.length(); j++) {
                char c = res.charAt(j);
                if(c == cur) {
                    count++;
                } else {
                    sb.append((char)(count+'0'));
                    sb.append(cur);
                    cur = c;
                    count = 1;
                }
            }
            sb.append((char)(count+'0'));
            sb.append(cur);
            res = sb.toString();
        }
        return res;
    }
}
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m+n];
        Arrays.fill(res,0);
        for(int i=m-1; i>=0; i--) {
            int carry = 0;
            for(int j=n-1; j>=0; j--) {
                int sum = res[i+j+1]+(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+carry;
                res[i+j+1] = sum%10;
                carry = sum/10;
            }
            res[i] += carry;
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<m+n && res[i] == 0) i++;
        while(i<m+n)    sb.append((char)(res[i++]+'0'));
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
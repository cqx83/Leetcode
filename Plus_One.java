public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length, carry = 1;
        for(int i=n-1; i>=0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
        }
        if(carry == 0)  return digits;
        int[] res = new int[n+1];
        System.arraycopy(digits,0,res,1,n);
        res[0] = carry;
        return res;
    }
}
public class Solution {
    public int reverse(int x) {
        int res = 0;
        for(;x != 0; x/=10) res = res*10 + x%10;
        return res;
    }
}
public class Solution {
    public double pow(double x, int n) {
        if(x == 0 || x == 1)    return x;
        if(x == -1) return n%2 == 0 ? 1 : -1;
        if(n == 0)  return 1;
        double half = pow(x,n/2);
        return half*half*(n%2 == 0 ? 1 : (n > 0) ? x : 1/x);
    }
}
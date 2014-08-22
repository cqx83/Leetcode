class Solution {
public:
    int sqrt(int x) {
        int l = 0, r = x/2+1;
        while(l <= r) {
            long long mid = l + (r-l)/2;
            long long pow = mid * mid;
            if(pow == x)  return mid;
            else if(pow < x)    l = mid + 1;
            else if(pow > x)    r = mid - 1;
        }
        return r;
    }
};
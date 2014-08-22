public class Solution {
    
    int close;

    public int threeSumClosest(int[] num, int target) {
        int n = num.length;
        if(n < 3)   return 0;
        close = num[0]+num[1]+num[2];
        Arrays.sort(num);
        for(int i=0; i<n; i++) {
            if(i != 0 && num[i] == num[i-1])    continue;
            if(twoSum(num,i+1,n-1,target,num[i]))
                return target;
        }
        return close;
    }

    boolean twoSum(int[] num, int left, int right, int t, int c) {
        int l = left, r = right;
        while(l < r) {
            if(l != left && num[l] == num[l-1]) {l++;continue;}
            if(r != right && num[r] == num[r+1])    {r--;continue;}
            int v = num[l]+num[r]+c;
            update(v,t);
            if(v < t)   l++;
            else if(v > t)  r--;
            else    return true;
        }
        return false;
    }

    void update(int sum, int target) {
        if(Math.abs(sum-target) < Math.abs(close-target))
            close = sum;
    }
}
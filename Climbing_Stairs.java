// Iteration
public class Solution {
    public int climbStairs(int n) {
        //fn = fn_1 + fn_2
        if(n <= 1)  return 1;
        int fn_1 = 1, fn_2 = 1, fn = 0;
        for(int i=2; i<=n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
}

// Recursive
public class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        return helper(n,map);
    }
    
    public int helper(int n, HashMap<Integer,Integer> map) {
        if(map.containsKey(n))
            return map.get(n);
        if(n == 0)  return 1;
        if(n < 0)   return 0;
        int res = helper(n-1,map) + helper(n-2,map);
        map.put(n,res);
        return res;
    }
}
// Trival
public class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        if(n == 0)	return 0;
        int res = height[0];
        for(int i=1; i<n; i++) {
        	while(i<n-1 && height[i] <= height[i+1])	i++;
        	int minH = height[i];
        	for(int j=i; j>=0; j--) {
        		minH = Math.min(height[j],minH);
        		res = Math.max(res,minH*(i-j+1));
        	}
        }
        return res;
    }
}

// Tricky
public class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        int[] nw = new int[n+1];
        for(int i=0; i<n; i++)
            nw[i] = height[i];
        nw[n] = 0;
        if(n == 0)  return 0;
        int res = 0, i = 0;
        Stack<Integer> s = new Stack<Integer>();
        while(i<=n) {
            if(s.empty() || nw[s.peek()] <= nw[i])
                s.push(i++);
            else {
                int index = s.pop();
                res = Math.max(res, nw[index]*(s.empty() ? i : i-1-s.peek()));
            }
        }
        return res;
    }
}
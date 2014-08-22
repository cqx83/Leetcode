public class Solution {
    public int longestValidParentheses(String s) {
    	int n = s.length(), max = 0, last = -1;
    	Stack<Integer> stack = new Stack<Integer>();
    	char[] str = s.toCharArray();
    	for(int i=0; i<n; i++) {
    		if(str[i] == '(')	stack.push(i);
    		else if(stack.empty())	last = i;
    		else {
    			stack.pop();
    			max = Math.max(max,i-(stack.empty() ? last : stack.peek()));
    		}
    	}
    	return max;
    }
}
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<tokens.length; i++) {
            if(isOperator(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;
                if(tokens[i].equals("+")) {
                    res = a + b;
                }
                else if(tokens[i].equals("-")) {
                    res = a-b;
                }
                else if(tokens[i].equals("*")) {
                    res = a*b;
                }
                else if(tokens[i].equals("/")) {
                    res = a/b;
                }
                stack.push(res);
            }
            else {
                stack.push(Integer.valueOf(tokens[i],10));
            }
        }
        return stack.pop();
    }

    public boolean isOperator(String s) {
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
}
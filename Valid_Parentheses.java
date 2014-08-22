public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == '(' || cur == '{' || cur =='[') {
                stack.push(cur);
                continue;
            }
            if(stack.empty())   return false;
            switch(cur) {
                case ')':
                    if(stack.peek() != '(') return false;
                    stack.pop();
                    break;
                case ']':
                    if(stack.peek() != '[') return false;
                    stack.pop();
                    break;
                case '}':
                    if(stack.peek() != '{') return false;
                    stack.pop();
                    break;
                default:
                    break;
            }
        }
        return stack.empty();
    }
}
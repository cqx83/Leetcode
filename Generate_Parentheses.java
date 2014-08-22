public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        Stack<Character> stack = new Stack<Character>();
        fun(0,0,n,stack,res);
        return res;
    }

    void fun(int l, int r, int n, Stack<Character> stack, ArrayList<String> res) {
        if(l == n && r == n) {
            StringBuilder sb = new StringBuilder();
            for(char c : stack) sb.append(c);
            res.add(sb.toString());
            return;
        }
        if(l < n) {
            stack.push('(');
            fun(l+1,r,n,stack,res);
            stack.pop();
        }
        if(r < l) {
            stack.push(')');
            fun(l,r+1,n,stack,res);
            stack.pop();
        }
    }
}
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        path += "/";
        int n = path.length(), s = -1;
        char[] arr = path.toCharArray();
        for(int i=0; i<n; i++) {
        	if(s == -1 && arr[i] != '/') {
        		s = i;
        	} else if (s != -1 && arr[i] == '/') {
        		process(stack, path.substring(s,i));
        		s = -1;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(String iter : stack) {
            sb.append("/" + iter);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    void process(Stack<String> stack, String s) {
        if(s.equals("."))   return;
        if(s.equals("..")) {
            if(!stack.empty())  stack.pop();
            return;
        }
        stack.push(s);
    }
}
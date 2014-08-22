public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> res = new ArrayList<String>();
        int n = words.length, len = -1;
        ArrayList<String> cur = new ArrayList<String>();
        for (int i=0; i<n; i++) {
        	if(len + words[i].length() + 1 <= L) {
        		cur.add(words[i]);
        		len += words[i].length() + 1;
        		continue;
        	}
        	generate(cur,res,len,L,false);
        	cur = new ArrayList<String>();
        	len = words[i].length();
        	cur.add(words[i]);
        }
        generate(cur,res,len,L,true);
        return res;
    }

    public void generate(ArrayList<String> cur, ArrayList<String> res, int len, int L, boolean last) {
        int wordCount = cur.size();
        if(wordCount == 1)  last = true;
    	int evenSpace = last ? 1 : (L-len)/(wordCount-1)+1, leftSpace = last ? 0 :(L-len)%(wordCount-1);
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<cur.size()-1; i++) {
    		String s = cur.get(i);
    		sb.append(s);
    		int space = last ? 1 : (evenSpace + (leftSpace <= 0 ? 0 : 1));
    		for(int j=0; j<space; j++)
    			sb.append(' ');
    		leftSpace--;
    	}
    	sb.append(cur.get(wordCount-1));
    	if(last) {
    		while(len < L) {
    			sb.append(' ');
    			len++;
    		}
    	}
    	res.add(sb.toString());
    }
}
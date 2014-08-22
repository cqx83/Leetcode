public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> q = new LinkedList<String>();
        HashSet<String> visit = new HashSet<String>();
        dict.add(end);
        q.add(start);visit.add(start);
        int curCount = 1, nextCount = 0, level = 1;
        while(q.size() > 0) {
        	String cur = q.poll();
        	for(String iter : children(cur,dict)) {
        		if(visit.add(iter)) {
        			if(iter.equals(end))	return level+1;
        			q.add(iter);
        			nextCount++;
        		}
        	}
        	if(--curCount == 0) {
        		curCount = nextCount;
        		nextCount = 0;
        		level++;
        	}
        }
        return 0;
    }

    public HashSet<String> children(String s, HashSet<String> dict) {
        HashSet<String> res = new HashSet<String>();
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<26; j++) {
                if(s.charAt(i) != 'a'+j) {
                    sb.setCharAt(i,(char)('a'+j));
                    if(dict.contains(sb.toString()))
                        res.add(sb.toString());
                }
            }
            sb.setCharAt(i,s.charAt(i));
        }
        return res;
    }
}
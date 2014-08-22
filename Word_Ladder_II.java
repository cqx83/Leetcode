public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        dict.add(end);
        HashSet<String> visit = new HashSet<String>();
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        HashMap<String, HashSet<String>> childStore = new HashMap<String, HashSet<String>>();
        queue.add(start);
        visit.add(start);
        int curCount = 1, nextCount = 0;
        HashSet<String> curLevel = new HashSet<String>();
        boolean found = false;
        while(queue.size() > 0) {
            String cur = queue.poll();
            if(cur.equals(end)) {
                found = true;
                break;
            }
            for(String iter : children(cur,dict,childStore)) {
                if(!visit.contains(iter)) {
                    nextCount++;
                    queue.add(iter);
                    curLevel.add(iter);
                    if(!map.containsKey(iter))
                        map.put(iter,new HashSet<String>());
                    map.get(iter).add(cur);
                }
            }
            if(--curCount == 0) {
                curCount = nextCount;
                nextCount = 0;
                visit.addAll(curLevel);
                curLevel.clear();
            }
        }
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(!found)  return res;
        return backTrack(end,start,map);
    }

    public ArrayList<ArrayList<String>> backTrack(String s, String t, HashMap<String, HashSet<String>> map) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s.equals(t)) {
            ArrayList<String> nw = new ArrayList<String>();
            nw.add(t);
            res.add(nw);
            return res;
        } 
        for(String iter : map.get(s)) {
            for(ArrayList<String> sub : backTrack(iter,t,map)) {
                sub.add(s);
                res.add(sub);
            }
        }
        return res;
    }

    public HashSet<String> children(String s, HashSet<String> dict, HashMap<String, HashSet<String>> childStore) {
        if(childStore.containsKey(s))
        	return childStore.get(s);
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
        childStore.put(s, res);
        return res;
    }
}
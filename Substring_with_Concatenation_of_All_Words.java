public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int l = L[0].length(), k = L.length;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0; i<k; i++) {
            String c = L[i];
            if(!map.containsKey(c)) 
                map.put(c,0);
            map.put(c,map.get(c)+1);
        }
        for(int i=0; i<=S.length()-l*k; i++) {
        	HashMap<String,Integer> ref = new HashMap<>(map);
        	for(int j=i,z=0; z<k; z++,j+=l) {
        		String tmp = S.substring(j,j+l);
        		if(!ref.containsKey(tmp))	break;
        		ref.put(tmp, ref.get(tmp)-1);
        		if(ref.get(tmp) == 0)	
        			ref.remove(tmp);
        		if(ref.size() == 0)
        			res.add(i);
        	}
        }
        return res;
    }
}
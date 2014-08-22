public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(String s : strs) {
            String t = sortStr(s);
            if(map.containsKey(t)) {
                map.get(t).add(s);
            }
            else {
            	ArrayList<String> tmp = new ArrayList<String>();
            	tmp.add(s);
            	map.put(t, tmp);
            }
        }
        ArrayList<String> res = new ArrayList<String>();
        for(Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
        	if(e.getValue().size() > 1) {
        		for(String s : e.getValue())
        			res.add(s);
        	}
        }
        return res;
    }
    
    public String sortStr(String s) {
        int[] buffer = new int[26];
        Arrays.fill(buffer,0);
        for(int i=0; i<s.length(); i++)
            buffer[s.charAt(i)-'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            for(int j=0; j<buffer[i]; j++) {
                sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }
}
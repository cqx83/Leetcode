public class Solution {
    public int longestConsecutive(int[] num) {
        int n = num.length, max = 1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<n; i++) {
            int v = num[i];
            if(map.containsKey(v))  continue;
            map.put(v,1);
            if(map.containsKey(v-1))    max = Math.max(max,merge(v-1,v,map));
            if(map.containsKey(v+1))    max = Math.max(max,merge(v,v+1,map));
        }
        return max;
    }

    int merge(int l, int r, HashMap<Integer,Integer> map) {
        int low = l - map.get(l) + 1;
        int high = r + map.get(r) - 1;
        int len = high - low + 1;
        map.put(low,len);
        map.put(high,len);
        return len;
    }
}
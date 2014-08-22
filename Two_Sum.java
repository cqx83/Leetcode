public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        int n = numbers.length;
        for(int i=0; i<n; i++) {
            if(map.containsKey(target-numbers[i])) {
                res[0] = map.get(target-numbers[i])+1;
                res[1] = i+1;
                break;
            }
            map.put(numbers[i],i);
        }
        return res;
    }
}
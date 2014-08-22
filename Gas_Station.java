public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length != cost.length)   return -1;
        int sum = 0, total = 0, j = -1, n = gas.length;
        for(int i=0; i<n; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(sum < 0) {
                sum = 0;
                j = i;
            }
        }
        return total >= 0 ? j+1 : -1;
    }
}
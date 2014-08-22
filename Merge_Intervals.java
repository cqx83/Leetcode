public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval arg0, Interval arg1) {
                if(arg0.start < arg1.start) return -1;
                else if(arg0.start > arg1.start)    return 1;
                return 0;
            }
        });
        ArrayList<Interval> res  = new ArrayList<Interval>();
        int i = 0, n = intervals.size();
        while(i < n) {
            int s = intervals.get(i).start, e = intervals.get(i).end;
            int j = i+1;
            for(; j<n && intervals.get(j).start <= e; j++) {
                e = Math.max(e,intervals.get(j).end);
            }
            res.add(new Interval(s,e));
            i = j;
        }
        return res;
    }
}
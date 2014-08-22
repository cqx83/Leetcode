// Naive
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        for(ListIterator<Interval> it = intervals.listIterator(); it.hasNext();) {
            Interval cur = it.next();
            if(newInterval.end < cur.start) {
                it.previous();
                it.add(newInterval);
                return intervals;
            } else if(newInterval.start > cur.end) {
                continue;
            } else {
                newInterval.start = Math.min(newInterval.start, cur.start);
                newInterval.end = Math.max(newInterval.end, cur.end);
                it.remove();
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}

// Tricky
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(intervals.size()==0) intervals.add(newInterval);
        int startPos=searchPosition(intervals,newInterval.start), 
            endPos=searchPosition(intervals,newInterval.end);
        
        int newStart=0;
        if(startPos>=0 && intervals.get(startPos).end>=newInterval.start){
            newStart=intervals.get(startPos).start;
        }else{
            newStart=newInterval.start;
            startPos++;
        }
        int newEnd=0;
        if(endPos>=0) newEnd= Math.max(newInterval.end,intervals.get(endPos).end);
        else newEnd = newInterval.end;
        for(int i=startPos;i<endPos+1;i++)
            intervals.remove(startPos);
        intervals.add(startPos,new Interval(newStart, newEnd));
        return intervals;
    }
    
    public int searchPosition(ArrayList<Interval> intervals, int x){
        int a=0, b=intervals.size()-1;
        while(a<=b){
            int mid=(a+b)/2;
            if(intervals.get(mid).start==x) return mid;
            else if(intervals.get(mid).start>x) b=mid-1;
            else a=mid+1;
        }
        return b;
    }
}
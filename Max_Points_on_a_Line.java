public class Solution {
    public int maxPoints(Point[] points) {
        int n = points.length, max = 0;
        if(n == 0)  return 0;
        if(n == 1)  return 1;
        HashMap<Double,Integer> map = new HashMap<Double,Integer>();
        for(int i=0; i<n; i++) {
            map.clear();
            int samePoint = 0, subMax = 1;
            for(int j=i+1; j<n; j++) {
                Point a = points[i], b = points[j];
                if(a.x == b.x && a.y == b.y ) {
                    samePoint++;
                    continue;
                }
                double sl = calSlope(points[i], points[j]);
                if(!map.containsKey(sl)) {
                    map.put(sl,1);
                }
                map.put(sl,map.get(sl)+1);
                subMax = Math.max(subMax, map.get(sl));
            }
            max = Math.max(max,subMax+samePoint);
        }
        return max;
    }

    public double calSlope(Point a, Point b) {
        double s = Double.MAX_VALUE;
        double x1=a.x, y1=a.y, x2=b.x, y2=b.y;
        if(a.x != b.x) {
            //s = ((double)(b.y-a.y))/((double)(b.x-a.x))
            if(y1 == y2)    return 0.0;
            s=(y2-y1)/(x2-x1);
        }
        return s;
    }
}
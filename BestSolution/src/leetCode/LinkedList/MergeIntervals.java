package leetCode.LinkedList;
import java.util.*;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>(); 
        if (intervals.size()==0) return res; 
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start-i2.start; 
            }
        });
        Interval prev = intervals.get(0); 
        int i=1; 
        while (i<intervals.size()){
            Interval cur = intervals.get(i); 
            if (cur.start<=prev.end){
                prev.end= Math.max(prev.end, cur.end); 
                intervals.remove(i); 
            }  else {
                i++; 
                prev=cur; 
            }
        }
        return intervals;
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
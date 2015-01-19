package leetCode.arrayString;
import java.util.*;
public class InsertIntervals {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i=0; 
        while (i<intervals.size()){
            if (intervals.get(i).end<newInterval.start) { i++; continue; }
            if (intervals.get(i).start>newInterval.end) {
                break;
            } 
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start); 
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end); 
            intervals.remove(i); 
        }
        intervals.add(i, newInterval); 
        return intervals;
    }
}
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
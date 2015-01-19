package question101_150;

import java.util.*;

public class InsertIntervals {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i =0; 
		while (i<intervals.size()) {
			if (newInterval.end<intervals.get(i).start) break; 
			if (newInterval.start>intervals.get(i).end) {i++; continue; }
			
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start); 
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end); 
			intervals.remove(i);  
		}
		intervals.add(i, newInterval); 
		return intervals; 
	}
	
	public static void main (String[] args) {
		Interval it1= new Interval(1, 5); 
    	Interval it2 = new Interval(3, 5);
    	Interval it3 = new Interval(6, 7);
    	Interval it4 = new Interval(8, 10);
    	Interval it5 = new Interval(12, 16);
    	List<Interval> list = new ArrayList<Interval>(); 
    	list.add(it1);
//    	list.add(it2); 
//    	list.add(it3); list.add(it4);
//    	list.add(it5); 
    	InsertIntervals iis = new InsertIntervals(); 
    	List<Interval> res = iis.insert(list, new Interval(2, 3)); 
    	for (int i=0; i<res.size(); i++) {
    		Interval cur = res.get(i); 
    		System.out.println(cur.start + " " + cur.end);
    	}
    	
	}
}

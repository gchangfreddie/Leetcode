package question101_150;

import java.util.*;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size()<=1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval in1, Interval in2){
                return in1.start-in2.start;
            }
        }); 
        int end = intervals.get(0).end; 
        int i=1; 
        while (i<intervals.size()) {
            if (intervals.get(i).start>end) {
                end = intervals.get(i++).end; 
            } else {
                intervals.get(i-1).end = Math.max(intervals.get(i).end, intervals.get(i-1).end);
                end = intervals.get(i-1).end; 
                intervals.remove(i); 
            }
        }    
        return intervals; 
    }
    
    public List<Interval> merge2(List<Interval> intervals) {
        if (intervals.size()<=1) return intervals;
        List<Interval> res = new ArrayList<Interval>(); 
        res.add(intervals.get(0)); 
        for (int i=1; i<intervals.size(); i++) {
            insert(res, intervals.get(i)); 
        }
        return res; 
    }
    
    public void insert(List<Interval> res, Interval n) {
        int i=0; 
        while (i<res.size()){
            if (n.start>res.get(i).end) {
                i++; continue; 
            }
            if (n.end<res.get(i).start) break; 
            n.start = Math.min(n.start, res.get(i).start);
            n.end = Math.max(n.end, res.get(i).end); 
            res.remove(i); 
        }
        res.add(i, n); 
    }
    
    public static void main(String[] args) {
    	Interval it4= new Interval(1, 4); 
    	Interval it3 = new Interval(2, 3);
    	Interval it2 = new Interval(8, 10);
    	Interval it1 = new Interval(15, 18);
    	List<Interval> list = new ArrayList<Interval>(); 
//    	list.add(it1); 
//    	list.add(it2);
    	list.add(it4); list.add(it3);
    	MergeIntervals mis = new MergeIntervals(); 
    	List<Interval> res = mis.merge(list);
    	System.out.println(res);
    }
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
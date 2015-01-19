package question.sixty.to.seventy;

import java.util.*;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] a) {
		if (a==null || a.length==0) return 0; 
		HashMap<Integer, Interval> hm = new HashMap<Integer, Interval>(); 
		int max=1; 
		for (int num : a) {
			if (!hm.containsKey(num)) {
				Interval interval = new Interval(); 
				if (hm.containsKey(num-1)){
					interval.lower = hm.get(num-1).lower;  
				} else {
					interval.lower = num; 
				}
				if (hm.containsKey(num+1)){
					interval.upper = hm.get(num+1).upper; 
				} else {
					interval.upper = num; 
				}
				hm.put(num, interval); 
				hm.get(interval.lower).upper = interval.upper; 
				hm.get(interval.upper).lower = interval.lower; 
				if ((interval.upper-interval.lower+1)>max)
					max = interval.upper-interval.lower+1; 
			}
		}
		return max; 
	}

	public class Interval {
		int upper; 
		int lower; 
	}

	public static void main(String[] args) {
		int[] a = new int[]{0,3,7,2,5,8,4,6,0,1}; 
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		System.out.println(lcs.longestConsecutive(a));
	}
}

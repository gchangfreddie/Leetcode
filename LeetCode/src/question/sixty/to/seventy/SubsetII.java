package question.sixty.to.seventy;

import java.util.*;

public class SubsetII {
	public static List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        res.add(new ArrayList<Integer>()); 
        if (num.length==0) return res; 
        Arrays.sort(num); 
        List<List<Integer>> tempRes = new ArrayList<List<Integer>>();
        for (int i=0; i<num.length; i++) {
            if (i==0 || num[i]!=num[i-1]) { 
                tempRes.clear(); 
                for (List<Integer> tempList : res) {
                    tempRes.add(new ArrayList<Integer>(tempList)); 
                }
            } 
            for (List<Integer> tempList : tempRes) {
                tempList.add(num[i]); 
                List<Integer> l = new ArrayList<Integer>(tempList); 
                res.add(l); 
            }
        }
        return res; 
	}
	public static void main(String[] args) {
		subsetsWithDup(new int[]{1,2,2}); 
		System.exit(0);
	}
}

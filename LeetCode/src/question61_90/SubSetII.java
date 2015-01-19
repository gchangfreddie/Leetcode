package question61_90;

import java.util.*;

public class SubSetII {
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num); 
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); 
        if (num==null || num.length==0) return res;   
        // HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>(); 
        ArrayList<Integer> al = new ArrayList<Integer>(); 
        res.add(al); 
        for (int i=0; i<num.length; i++) {
            // HashSet<ArrayList<Integer>> tempSet = (HashSet<ArrayList<Integer>>) hs.clone(); 
            ArrayList<ArrayList<Integer>> tempSet = (ArrayList<ArrayList<Integer>>) res.clone(); 
            for (ArrayList<Integer> elem : tempSet) {
                ArrayList<Integer> temp = (ArrayList<Integer>)elem.clone(); 
                if (i>0&&num[i]==num[i-1]){
                	if (i==temp.size() || (temp.size()==1 && temp.get(0)==num[i])){
                		temp.add(num[i]); 
                        res.add(temp); 
                	}
                } else{
	                temp.add(num[i]); 
	                res.add(temp); 
                }
            }    
        }
        // res = new ArrayList<ArrayList<Integer>>(hs); 
        return res; 
    }
	
	
	public static List<List<Integer>> subsetsWithDup1(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        res.add(new ArrayList<Integer>()); 
        if (num.length==0) return res; 
        Arrays.sort(num); 
        for (int i=0; i<num.length; i++) {
            List<List<Integer>> tempRes = new ArrayList<List<Integer>>(); 
            for (List<Integer> tempList : res) {
                tempRes.add(new ArrayList<Integer>(tempList)); 
            }
            for (List<Integer> tempList : tempRes) {
                tempList.add(num[i]); 
            }
            res.addAll(tempRes); 
        }
        return res; 
    }
	
	
	public static void main(String[] args) {
		List<List<Integer>> res = subsetsWithDup1(new int[]{1, 2,2}); 
		for (List<Integer> list: res) {
			System.out.println(list);
		}
		System.exit(0);
	}
}

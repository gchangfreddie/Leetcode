package question31_60;

import java.util.*;

public class Subset {
	    public static List<List<Integer>> subsets1(int[] S) {
	    	List<List<Integer>> res = new ArrayList<List<Integer>>() ;
	        List<Integer> list = new ArrayList<Integer>(); 
	        res.add(list); 
	        if (S.length==0) return res; 
	        Arrays.sort(S);
	        for (int i=0; i<S.length; i++) {
	            List<List<Integer>> tempRes = new ArrayList<List<Integer>>(); 
	            for (List<Integer> tempList : res) {
	                tempRes.add(new ArrayList<Integer>(tempList));
	            }
	            for (List<Integer> tempList : tempRes) {
	                tempList.add(tempList.size(), S[i]);
	            }
	            res.addAll(tempRes); 
	        }
	        return res; 
	    }
	    
	    public static void main(String[] args){
	    	List<List<Integer>> a  = subsets1(new int[] {4,1,0}); 
	    	for (List<Integer> b: a) {
	    		for (Integer c: b) {
	    			System.out.print(c);
	    		}
	    		System.out.println();
	    	}
	    }
}

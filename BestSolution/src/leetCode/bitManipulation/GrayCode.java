package leetCode.bitManipulation;

import java.util.*;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>(); 
         if (n==0) {
             res.add(0); return res;
         }
         List<Integer> temp =grayCode(n-1); 
         res.addAll(temp); 
         for (int i=temp.size()-1; i>=0; i--) {
             res.add(temp.get(i)|1<<(n-1)); 
         }
         return res;
    }
	
	public List<Integer> grayCodeInterative(int n) {
		List<Integer> res = new ArrayList<Integer>(); 
        res.add(0); 
        for (int i=1; i<=n; i++) {
            List<Integer> temp = new ArrayList<Integer>(res); 
            for (int j=temp.size()-1; j>=0; j--){
                res.add(temp.get(j)|1<<(i-1)); 
            }
        }
        return res; 
    }
}

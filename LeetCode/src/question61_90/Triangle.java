package question61_90;

import java.util.ArrayList;

public class Triangle {
	 public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        if (triangle==null || triangle.size()==0) return 0; 
	        int level = triangle.size(); 
	        ArrayList<Integer> al = triangle.get(level-1);
	        int l = al.size(); 
	        int[] max = new int[l];
	        for (int i=0; i<l; i++) {
	        	max[i] = al.get(i); 
	        }
	        for (int i=level-2; i>=0; i--) {
	        	al = triangle.get(i); 
	        	for (int j=0; j<al.size();j++) {
	        		max[j] = Math.min(max[j], max[j+1]) + al.get(j); 
	        	}
	        }
	        return max[0]; 
	    }
	    
}

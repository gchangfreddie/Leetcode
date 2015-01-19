package RecursiveAndDP;

import java.util.*;

public class PasicalTrianglesII {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>(); 
        res.add(1); 
        for (int i=1; i<=rowIndex; i++){
            res.add(1, i==1 ? 1 : res.get(0)+res.get(1));
            for (int j=2; j<res.size()-1; j++){
            	/*
            	 * please notice must use set instead of add, add means insert, so the 
            	 * res.size will increase endless.
            	 */
                res.set(j, res.get(j)+res.get(j+1)); 
            }
        }
        return res;
    }
}

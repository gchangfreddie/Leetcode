package RecursiveAndDP;

import java.util.*;
public class SubSet {
	public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        res.add(new ArrayList<Integer>()); 
        if (S.length==0)  return res; 
        Arrays.sort(S); 
        for (int i=0; i<S.length; i++) {
            List<List<Integer>> tempRes = new ArrayList<List<Integer>>(); 
            for (List<Integer> list : res) tempRes.add(new ArrayList<Integer>(list)); 
            for (List<Integer> list : tempRes) {
                list.add(S[i]); 
            }
            res.addAll(tempRes); 
        }
        return res;
    }
}

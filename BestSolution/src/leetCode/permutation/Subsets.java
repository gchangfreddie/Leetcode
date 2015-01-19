package leetCode.permutation;
import java.util.*;
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        res.add(new ArrayList<Integer>()); 
        Arrays.sort(S);
        for (int i=0; i<S.length; i++) {
            List<List<Integer>> tempRes = new ArrayList<List<Integer>>(); 
            for (List<Integer> l : res) tempRes.add(new ArrayList<Integer>(l)); 
            for (List<Integer> l: tempRes)  l.add(S[i]); 
            res.addAll(tempRes); 
        }
        return res;
    }
}

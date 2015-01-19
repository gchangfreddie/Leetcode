package leetCode.combination;

import java.util.*;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        construct(n, k, res, 0, new ArrayList<Integer>()); 
        return res;
    }
    
    public void construct(int n, int k, List<List<Integer>> res, int index, List<Integer> list){
        if (index==k) {
            res.add(new ArrayList<Integer>(list)); 
            return; 
        }
        int start = list.isEmpty() ? 0 : list.get(list.size()-1); 
        for (int i=start+1; i<=n; i++){
            list.add(i); 
            construct(n, k, res, index+1, list); 
            list.remove(list.size()-1); 
        }
    }
}

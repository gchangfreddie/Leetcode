package leetCode.combination;

import java.util.*;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        Arrays.sort(candidates); 
        if (candidates.length==0 || candidates[0]>target) return res;
        dfs(candidates, target, res, new ArrayList<Integer>(), 0); 
        return res;
    }
    
    public void dfs(int[] a, int t, List<List<Integer>> res, List<Integer> list, int index){
        if (t==0) {
            res.add(new ArrayList<Integer>(list)); 
        } else {
            for (int i=index; i<a.length; i++) {
                if (a[i]>t) break; 
                list.add(a[i]); 
                dfs(a, t-a[i], res, list, i); 
                list.remove(list.size()-1); 
            } 
        }
    }
}

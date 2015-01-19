package leetCode.combination;

import java.util.*;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        Arrays.sort(num); 
        if (num.length==0 || num[0]>target) return res; 
        dfs(num, target, res, new ArrayList<Integer>(), 0); 
        return res;
    }
    
    public void dfs(int[] num, int t, List<List<Integer>> res, List<Integer> list, int index){
        if (t==0) {
            res.add(new ArrayList<Integer>(list)); 
        } else {
            for (int i=index; i<num.length; i++) {
                if (num[i]>t) break;
                list.add(num[i]); 
                dfs(num, t-num[i], res, list, i+1); 
                list.remove(list.size()-1); 
                while (i<num.length-1 && num[i+1]==num[i]) i++; 
            }
        }
    }
}

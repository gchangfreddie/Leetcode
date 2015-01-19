package dfsAndBfs;
import java.util.*;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(Integer[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        Arrays.sort(candidates, new Comparator<Integer>(){
        	public int compare(Integer i1, Integer i2){
        		return i2.compareTo(i1); 
        	}
        }); 
        if (candidates.length==0 || candidates[0]>target) return res;
        dfs(candidates, target, res, new ArrayList<Integer>(), 0); 
        return res;
    }
    
    public static boolean dfs(Integer[] a, int t, List<List<Integer>> res, List<Integer> list, int index){
        if (t==0) {
            res.add(new ArrayList<Integer>(list)); 
            return true;
        } else {
            for (int i=index; i<a.length; i++) {
                if (a[i]>t) continue; 
                list.add(a[i]); 
                if ( dfs(a, t-a[i], res, list, i)) return true; 
                list.remove(list.size()-1); 
                while (i<a.length-1 && a[i]==a[i+1]) i++;
            } 
        }
        return false;
    }
    
    public static void main(String[] args){
    	CombinationSum cs = new CombinationSum(); 
    	Integer[] a = new Integer[]{2,3,6,7,7}; 
    	List<List<Integer>> res = cs.combinationSum(a, 7); 
    	for (List<Integer> list : res){
    		System.out.println(list);
    	}
    	
    }
}

package question.sixty.to.seventy;

import java.util.*;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates); 
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		List<Integer> list = new ArrayList<Integer>();
		dfs(candidates, target, res, list, 0); 
		return res;
	}

	public void dfs(int[] c, int t, List<List<Integer>> res, List<Integer> list, int start){
		if (t==0) {
			res.add(new ArrayList<Integer>(list));
		} else if (t>0){
			for (int i=start; i<c.length; i++) {
				list.add(c[i]); 
				dfs(c, t-c[i], res, list, i); 
				list.remove(list.size()-1); 
			}
		}
	}


	public static void main(String[] args) {
		int[] a = new int[]{1, 2}; 
		CombinationSum cs = new CombinationSum(); 
		List<List<Integer>> res = cs.combinationSum(a, 3); 
		for (List<Integer> al : res ) {
			for (int i : al) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.exit(0);
	}
}

package question61_90;

import java.util.*;

public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		if (num==null || num.length ==0) return res; 
		Arrays.sort(num); 
		int[] visited = new int[num.length]; 
		List<Integer> list = new ArrayList<Integer>(); 
		dfs (visited, num, 0, res, list); 
		return res; 
	}
	
	public void dfs(int[] visited, int[] num, int start, List<List<Integer>> res, List<Integer> list) {
		if (start==num.length) {
			List<Integer> temp = new ArrayList<Integer>(list); 
			res.add(temp); 
		} else {
			for (int i=0; i<num.length; i++) {
				if (visited[i]==0 ) {
					list.add(num[i]); 
					visited[i] = 1; 
					dfs(visited, num, start+1, res, list); 
					list.remove(list.size()-1); 
					visited[i] = 0; 
					while(i<num.length-1&&num[i+1]==num[i]){
						++i;  
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PermutationII pii = new PermutationII(); 
		List<List<Integer>> res = pii.permuteUnique(new int[]{-2, -1,3,-1}); 
		for (List<Integer> r : res) {
			for (int num : r) {
				System.out.print(" " + num);
			}
			System.out.println();
		}
	}
}

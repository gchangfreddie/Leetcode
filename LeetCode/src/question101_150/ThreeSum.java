package question101_150;

import java.util.*;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] a) {
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		if (a==null || a.length<3) return res;
		Arrays.sort(a); 
		for (int i=0; i<a.length-2; i++) {
			if (a[i]>0) break; 
			if (i>0 && a[i]==a[i-1]) continue; 
			List<List<Integer>> list = findTwoSum(a, -a[i], i+1); 
			res.addAll(list); 
		}
		return res; 
	}
	
	public List<List<Integer>> findTwoSum(int[] a, int target, int index){
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for (int i=index; i<a.length; i++) {
			if (!map.containsKey(a[i])) map.put(target-a[i], a[i]);
			else {
				if (i<a.length-1 && a[i]==a[i+1]) 
					continue;
				ArrayList<Integer> list = new ArrayList<Integer>(); 
				list.add(-target); 
				list.add(map.get(a[i]));
				list.add(a[i]); 
				res.add(list); 
			}
		}
		return res; 
	}
	
	public static void main(String[] args){
		int[] a = new int[]{-1, 0, 1};
		List<List<Integer>> res = new ThreeSum().threeSum(a); 
		for (List<Integer> l : res) {
			System.out.println(l);
		}
		
	}
}

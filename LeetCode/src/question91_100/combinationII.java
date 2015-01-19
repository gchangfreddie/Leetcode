package question91_100;

import java.util.*;

public class combinationII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if (num==null || num.length==0) return res; 
        Arrays.sort(num); 
        List<Integer> list = new ArrayList<Integer>(); 
        foo(num, target, res, list, 0, 0); 
        return res; 
    }
	
	public void foo(int[] a, int t, List<List<Integer>> res, List<Integer> list, int sum, int index){
		if (sum == t) {
			ArrayList<Integer> temp = new ArrayList<Integer>(list);
			res.add(temp);
			return ; 
		} 
		for (int i=index; i<a.length; i++) {
			if (a[i]+sum>t) continue; 
			list.add(a[i]); 
			foo(a, t, res, list, sum+a[i], i+1); 
			list.remove(list.size()-1); 
			while(i<a.length-1 && a[i]==a[i+1])i++; 
		}
	}
	
	public static void main(String[] args) {
		combinationII cb2 = new combinationII();
		List<List<Integer>> res = cb2.combinationSum2(new int[]{1}, 2);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}

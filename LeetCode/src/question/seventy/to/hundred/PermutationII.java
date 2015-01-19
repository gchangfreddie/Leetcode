package question.seventy.to.hundred;

import java.util.*;

public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new LinkedList<List<Integer>>(); 
        if (num==null || num.length == 0) return res; 
        permutation(num, 0, res, new LinkedList<Integer>()); 
        return res; 
    }
    
    public void permutation(int[] a, int start, List<List<Integer>> res, List<Integer> list) {
        if (start==a.length-1) {
            list.add(a[start]); 
            res.add(list); 
        } else {
            for (int i=start; i<a.length; i++) {
            	 if (exchange(start, i, a)){
                     List<Integer> temp = new LinkedList<Integer>(list); 
                     temp.add(a[start]); 
                     permutation(a, start+1, res, temp); 
                     exchange(start, i, a);
                 }
            }
        }
    }
    
    public boolean exchange(int i, int j, int[] a) {
    	if (i!=j && a[i]==a[j]) return false; 
        if (i==j) return true;
        int temp = a[i]; 
        a[i]= a[j]; 
        a[j]= temp; 
        return true;
    }
    
    
    public List<List<Integer>> permuteUnique1(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        List<Integer> list = new ArrayList<Integer>(); 
        boolean[] marked = new boolean[num.length]; 
        Arrays.sort(num); 
        dfs(num, res, list, marked, 0); 
        return res; 
    }
    
    public void dfs(int[] num, List<List<Integer>> res, List<Integer> list, boolean[] marked, int layer){
        if (layer==num.length) {
            res.add(new ArrayList<Integer>(list)); 
        } else{
            for (int i=0; i<num.length; i++){
                if (!marked[i]) {
                    marked[i]=true; 
                    list.add(num[i]); 
                    dfs(num, res, list, marked, layer+1); 
                    list.remove(list.size()-1); 
                    marked[i]=false; 
                    while(i<num.length-1 && num[i]==num[i+1]) i++; 
                }
            }
        }
    }
    public static void main(String[] args) {
    	PermutationII p = new PermutationII(); 
    	List<List<Integer>> list = p.permuteUnique(new int[]{1,1,2}); 
    	for (List<Integer> l : list){
    		for (int i: l) {
    			System.out.print(i+", ");
    		}
    		System.out.println();
    	}
    }
}

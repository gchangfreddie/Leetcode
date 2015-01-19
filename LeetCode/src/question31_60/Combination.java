package question31_60;

import java.util.*;

public class Combination {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>(); 
        if (n==0) return a; 
        return putCom(a, n, k); 
    }
    
    private ArrayList<ArrayList<Integer>> putCom(ArrayList<ArrayList<Integer>> a, int n, int k) {
        if (k==1) {
            for (int i=1; i<=n; i++) {
                ArrayList<Integer> b = new ArrayList<Integer>(); 
                b.add(i); 
                a.add(b); 
            }
            return a; 
        }
        a = putCom(a, n, k-1); 
        ArrayList<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>(); 
        for (ArrayList<Integer> b : a){
            for (int i=b.get(b.size()-1)+1; i<=n; i++) {
                ArrayList<Integer> c = new ArrayList<Integer>(b); 
                c.add(i); 
                aux.add(c); 
            }
        }
        return aux; 
    }
    
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        List<Integer> list = new ArrayList<Integer>(); 
        dfs(res, n, k, list, 0); 
        return res; 
    }
    
    public void dfs(List<List<Integer>> res, int n, int k, List<Integer> list, int layer){
        if (layer==k) {
            res.add(new ArrayList<Integer>(list)); 
        } else {
            int start = list.isEmpty() ? 0: list.get(list.size()-1); 
            for (int i=start+1; i<=n; i++) {
                list.add(i); 
                dfs(res, n, k, list, layer+1); 
                list.remove(list.size()-1); 
            }
        }
    }
    
    public static void main(String[] args ){
    	ArrayList<ArrayList<Integer>> a = new Combination().combine(1, 1);
    	for (ArrayList<Integer> b: a) {
    		for (Integer i: b) 
    			System.out.print(" " + i);
    		System.out.println();
    	}
    	
    }
}

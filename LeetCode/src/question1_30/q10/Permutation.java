package question1_30.q10;

import java.util.ArrayList;

public class Permutation {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> b = new ArrayList<Integer>(); 
		a.add(b); 
		if (num==null || num.length==0) return a; 
		return put(a, 0, num); 
	}

	private ArrayList<ArrayList<Integer>> put(ArrayList<ArrayList<Integer>> a, int index, int[] num) {
		if (index==num.length) return a; 
		ArrayList<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();  
		for (ArrayList<Integer> b : a) {
			for (int i=0; i<=b.size(); i++) {
				ArrayList<Integer> c = (ArrayList<Integer>) b.clone(); 
				c.add(i, num[index]); 
				aux.add(c); 
			}
		}
		a = (ArrayList<ArrayList<Integer>>) aux.clone(); 
		
		// pass by reference, so have to return it. 
		return put(a, index+1, num); 
	}
	
	public static void main(String[] args) {
		Permutation p = new Permutation(); 
		p.permute(new int[]{1, 2}); 
		System.exit(0);
	}
}

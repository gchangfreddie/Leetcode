package First30;

import java.util.*;

public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		if (numRows == 0) return null; 
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> b = new ArrayList<Integer>(); 
		b.add(1); 
		a.add(b); 
		
		for (int i=1; i<numRows; i++) {
			b = new ArrayList<Integer>(); 
			b.add(0, 1); 
			ArrayList<Integer> c = a.get(i-1); 
			for (int j=1; j<=i-1; j++) {
				b.add(j, c.get(j-1) + c.get(j) ); 
			}
			b.add(i, 1); 
			a.add(b);
		}
		return a; 
	}
	
	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle(); 
		ArrayList<ArrayList<Integer>> res = pt.generate(5); 
		for (int i=0; i<res.size(); i++) {
			ArrayList<Integer> b = res.get(i); 
			for (int j=0; j<b.size(); j++) {
				System.out.print(b.get(j)); 
			}
			System.out.println();
		}
	}
	
}

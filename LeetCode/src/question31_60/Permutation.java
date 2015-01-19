package question31_60;

import java.util.*;

public class Permutation {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>(); 
		if (num==null||num.length==0) return a; 
		a.add(new ArrayList<Integer>()); 
		for (int i=0; i<num.length; i++) {
			// we must create a new ArrayList of ArrayList, cause when we loop the ArrayList of ArrayList, we will keep adding new items to it
			//that will cause the endless loop. 
			ArrayList<ArrayList<Integer>> newAL = new ArrayList<ArrayList<Integer>>(a); 
			a.clear(); 
			for (ArrayList<Integer> list : newAL){
				for (int j=0; j<=list.size(); j++) {
					ArrayList<Integer> temp = new ArrayList<Integer>(list);
					temp.add(j, num[i]); 
					//we must create a new ArrayList of Integer, otherwise when we 
					// call list.remove(j), if we use newAL.add(list), the item in newAL will change correspondingly 
					a.add(temp);
				}
			}
		}
		return a; 
	}   
	
	public List<List<Integer>> permute1(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		if (num.length==0) return res;
		res.add(new ArrayList<Integer>()); 
		boolean[] mark = new boolean[num.length]; 
		return DFS(num, mark, res, 0); 
	}

	public List<List<Integer>> DFS(int[] num, boolean[] mark, List<List<Integer>> res, int layer) {
		if (layer==num.length) return res; 
		List<List<Integer>> per =new ArrayList<List<Integer>>(); 
		for (int i=0; i<num.length; i++){
			if (!mark[i]) {
				mark[i]=true; 
				List<List<Integer>> temp = new ArrayList<List<Integer>>(); 
				for (List<Integer> list : res) {
					List<Integer> aux = new ArrayList<Integer>(list); 
					aux.add(num[i]);
					temp.add(aux); 
				}
				per.addAll(DFS(num, mark, temp, layer+1)); 
				mark[i]=false; 
			}
		}
		return per; 
	}

	public static void main(String[] args) {
		Permutation p = new Permutation();
		int[] num = new int[] {1, 2, 3}; 
		ArrayList<ArrayList<Integer>> res = p.permute(num);
		for (ArrayList<Integer> list : res){
			System.out.println(list);
		}
	}

}

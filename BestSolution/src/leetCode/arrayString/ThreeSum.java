package leetCode.arrayString;
import java.util.*;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		if (num.length<=2) return res; 
		Arrays.sort(num); 
		for (int i=0; i<num.length-2; i++) {
			if (num[i]>0) return res; 
			int j=i+1,k=num.length-1; 
			while(j<k){
				if (num[i]+num[j]+num[k]==0) {
					List<Integer> list = new ArrayList<Integer>(); 
					list.add(num[i]); list.add(num[j]); list.add(num[k]); 
					res.add(list); 
					j++; k--;
					while (j<k && num[j]==num[j-1]) j++;
					while (k>j && num[k]==num[k+1]) k--;
				} else {
					if (num[i]+num[j]+num[k]>0) k--; 
					else j++; 
				}
			}
			while (i<num.length-3 && num[i]==num[i+1]) i++; 
		}
		return res; 
	}

	public static void main(String[] args){
		int[] a = new int[]{0, 0, 0, 0};
		List<List<Integer>> res = threeSum(a); 
		for (List<Integer> l : res) {
			System.out.println(l);
		}

	}


}

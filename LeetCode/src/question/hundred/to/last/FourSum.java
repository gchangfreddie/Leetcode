package question.hundred.to.last;

import java.util.*;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> res = new  ArrayList<List<Integer>>(); 
        if (num==null || num.length < 4) return res; 
        Arrays.sort(num);
        for (int i=0; i<num.length-3; i++) {
        	if (i>0 && num[i]==num[i-1]) continue; 
        	for (int j= i+1; j<num.length-2; j++) {
        		if (j>i+1 && num[j]==num[j-1]) continue; 
        		List<Integer> list = new ArrayList<Integer>(); 
        		list.add(num[i]); 
        		list.add(num[j]); 
        		int k=j+1, l=num.length-1; 
        		while(k<l) {
        			int sum = num[k]+num[l]+num[i]+num[j];
        			if (sum==target) {
        				List<Integer> temp = new ArrayList<Integer>(list); 
        				temp.add(num[k]); 
        				temp.add(num[l]); 
        				res.add(temp); 
        				k++; l--; 
        			} else if (sum<target) {
        				k++; 
        			} else {
        				l--; 
        			}
        			while (k>j+1 && k<num.length && num[k]==num[k-1]) k++; 
        			while (l<num.length-1 && l>j+1 && num[l]==num[l+1]) l--; 
        		}
        	}
        }
        return res; 
    }
	
	public List<List<Integer>> find3Sum(int[] a, int start, int target, int num){
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		for (int i=start; i<a.length-2; i++) {
			if (i>start && a[i]==a[i-1]) continue; 
			ArrayList<Integer> temp  = new ArrayList<Integer>(); 
			temp.add(num); 
			temp.add(a[i]); 
			List<List<Integer>> list = find2Sum(a, i+1, target-a[i], temp); 
			res.addAll(list); 
		}
		return res; 
	}
	
	public List<List<Integer>> find2Sum(int[] a, int start, int target, List<Integer> list){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		for (int i=start; i<a.length; i++) {
			if (map.containsKey(a[i])){
				List<Integer> temp = new ArrayList<Integer>(list); 
				temp.add(map.get(a[i])); 
				temp.add(a[i]); 
				res.add(temp);
			} else {
				map.put(target-a[i], a[i]); 
			}
		}
		return res; 
	}
	
	public List<List<Integer>> fourSum1(int[] num, int target) {
        Arrays.sort(num); 
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        for (int i=0; i<num.length-3; i++) {
            if (num[i]>target/4) break;
            if (i>0 && num[i]==num[i-1]) continue; 
            for (int j=i+1; j<num.length-2; j++) {
                if (j>i+1 &&num[j]==num[j-1]) continue;
                List<Integer> list = new ArrayList<Integer>(); 
                list.add(num[i]); list.add(num[j]); 
                find2Sum(num, j+1, target-num[i]-num[j], list, res); 
            }
        }
        return res;
    }
    
    public void find2Sum(int[] num, int start, int target, List<Integer> list, List<List<Integer>> res) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i=start; i<num.length; i++) {
            if(map.containsKey(num[i])) {
                List<Integer> temp = new ArrayList<Integer>(list);
                temp.add(num[map.get(num[i])]); 
                temp.add(num[i]); 
                res.add(temp); 
                map.remove(num[i]); 
            } else{
            	if (i>start && num[i]==num[i-1]) continue;
                map.put(target-num[i], i); 
            }
        }
    }
	
	public static void main(String[] args) {
		int[] a = new int[]{0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7};
		List<List<Integer>> res = new FourSum().fourSum1(a, 6); 
		
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}

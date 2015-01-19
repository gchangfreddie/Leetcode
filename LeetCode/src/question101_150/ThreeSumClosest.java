package question101_150;

import java.util.*;

public class ThreeSumClosest {
	public int threeSumClosest(int[] a, int target) {
		if (a==null || a.length  <3) return 0; 
		Arrays.sort(a); 
		int res = a[0]+a[1]+a[2]; 
		int dif = Math.abs(res-target); 
		for (int i=0; i<a.length-2; i++) {
//			if (a[i]>target) return res; // this line is wrong, cause target maybe negative number
			int temp = findTwoSum(a, i+1, target-a[i]); 
			if (temp==target-a[i]) return target; 
			else if (Math.abs(temp+a[i]-target)<dif) {
				dif = Math.abs(temp+a[i]-target); 
				res = temp+a[i]; 
			}
		}
		return res; 
	}
	
	public int threeSumClosest1(int[] num, int target) {
        Arrays.sort(num); 
        int res = 0, diff = Integer.MAX_VALUE; 
        for (int i=0; i<num.length-2; i++){
            int j=i+1, k=num.length-1; 
            while(j<k){
                int sum=num[i]+num[j]+num[k]; 
                if (Math.abs(sum-target)<diff) {
                    diff=Math.abs(sum-target); res=sum;
                }    
                if (sum<target) j++; 
                else if (sum<target) k--; 
                else return sum;
            }
        }
        return res;
    }
	
	public int findTwoSum(int[] a, int index, int target) {
		int i=index, j = a.length-1;
		int min = Integer.MAX_VALUE; 
		int res = a[i]+a[j]; 
		while (i<j) {
			int sum = a[i]+a[j]; 
			if (sum<target) i++; 
			else if (sum>target) j--; 
			else if (sum==target) return sum; 
			if (Math.abs(sum-target)<min) res = sum;  
			min = Math.min(min, Math.abs(sum-target));
		}
		return res; 
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{0,2,1,-3}; 
//		int[] a = new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10}; 
		System.out.println(new ThreeSumClosest().threeSumClosest1(a, 1)); 
	}
}

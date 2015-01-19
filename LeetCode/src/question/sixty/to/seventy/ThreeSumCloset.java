package question.sixty.to.seventy;

import java.util.Arrays;

public class ThreeSumCloset {
	public int threeSumClosest(int[] num, int target) {
        int res = 0; 
        if (num==null || num.length==0) return res; 
        Arrays.sort(num);
        int l=num.length, min = Integer.MAX_VALUE; 
        for (int i=0; i<l-2; i++) {
            int j=i+1, k=l-1; 
            while (j<l-1 && k>i+1) {
	            int sum = num[i] + num[j] + num[k]; 
	            if (sum==target) return sum; 
	            if (Math.abs(sum-target)<min) {
	            	min=Math.abs(sum-target); 
	            	res = sum; 
	            }
	            if (sum<target) j++; 
	            else k--; 
            }
        }
        return res; 
    }
}

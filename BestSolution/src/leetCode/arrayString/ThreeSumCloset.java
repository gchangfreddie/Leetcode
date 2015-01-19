package leetCode.arrayString;

import java.util.Arrays;

public class ThreeSumCloset {
	public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num); 
        int min = Integer.MAX_VALUE, res=0; 
        for (int i=0; i<num.length-2; i++){
            int j=i+1, k=num.length-1;
            while (j<k){
                int sum = num[i]+num[j]+num[k]; 
                if (sum==target) return sum; 
                if (Math.abs(sum-target)<min) {
                    res = sum; 
                    min = Math.abs(sum-target);
                }
                if (sum<target) j++; 
                else k--; 
            }
        }
        return res; 
    }
}

package question61_90;

public class ThreeSumClosest {
	 public int threeSumClosest(int[] num, int target) {
		 if (num==null || num.length<=2) return 0; 
	        int minV=Integer.MAX_VALUE; 
	        int res=0; 
	        for (int i=0; i<num.length-2; i++) {
	            for (int j=i+1; j<num.length-1; j++) {
	                for (int k=j+1; k<num.length; k++) {
	                    int sum = num[i] + num[j] + num[k]; 
	                    if (Math.abs(sum-target) < minV) {
	                    	minV = Math.abs(sum-target); 
	                    	res = sum; 
	                    	if (minV==0) return res;
	                    }
	                }
	            }
	        }
	        return res; 
	    }
	
}

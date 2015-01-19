package algorithm;

import java.util.Arrays;

/*
 * Given an int array A[], define: distance=A[i]+A[j]+(j-i), j>=i. Find max distance in A[]?
 */
public class MaxDistance {
	public int maxDistance(int[] a){
//		if (a.length==0) return 0; 
//		int[] dp= new int[a.length]; 
//		dp[0]=a[0]; 
//		int max = a[0]; 
//		for (int i=1; i<a.length; i++) {
//			if (a[i]-i>max) max = a[i]-i; 
//			dp[i]=a[i]+i+max;
//		}
// 		Arrays.sort(dp);
// 		return dp[a.length-1]; 
//		int i=0, j=a.length-1, max=0; 
//		while (i<j){
//			int dis = a[i]+a[j]+(j-i); 
//			if (dis>max) 
//				max=dis; 
//			if (a[i+1]-a[i]>a[j-1]-a[j]) i++;
//			else j--; 
//		}
//		return max; 
		int max=a[0]-0, res=0; 
		for (int i=1; i<a.length;i++) {
			if (a[i]+i+max>res) res = a[i]+i+max;
			if (max<a[i]-i) max=a[i]-i; 
		}
		return res;
	}
	
	public static void main(String[] args) {
    	MaxDistance cm = new MaxDistance(); 
    	int[] height = new int[]{3,3,3,5,6,4}; 
    	System.out.println(cm.maxDistance(height));		
    }
	
}

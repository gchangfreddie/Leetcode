package First30;

public class MaxSubArray {
//	public static int maxSubArray(int[] A) {
//		if (A==null || A.length==0) return 0; 
//		int sum=0, max=Integer.MIN_VALUE; 
//		for (int i=0; i<A.length; i++) {
//			sum += A[i]; 
//			if (sum>max) 
//				max=sum; 
//			if (sum<0) // this is a key step, if sum<0, we should not use it for the following search, we should start over from next element.
//				sum=0; 
//
//		}
//		return max; 
//	}
	
	public static int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int[] res = maxSubArray(A,0,A.length-1);
       return res[0];
    }
    
    public static int[] maxSubArray(int [] A, int start, int end){
        int[] res = new int[4];
            
        if(start==end){
            res[0]=A[start];
            res[1]=A[start];
            res[2]=A[start];
            res[3]=A[start];
        }else if(start<end){
            int mid=(start+end)/2;
            int[] left = maxSubArray(A, start,mid);
            int[] right = maxSubArray(A, mid+1,end);
            
            res[3]=left[3]+right[3];
            res[2]=Math.max(right[2],right[3]+left[2]);
            res[1]=Math.max(left[1],left[3]+right[1]);
            
            res[0] = Math.max(right[0],Math.max(left[0],left[2]+right[1]));
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] n = new int[]{-2,1,-3,4,-1,2,1,-5,4}; 
		System.out.println(maxSubArray(n));
	}
	
	public static int maxSubArray(int[] a, int len) {
		if (a==null && a.length==0) return 0; 
		return maxSum(a, 0, a.length-1, Integer.MIN_VALUE); 
	}
	
	public static int maxSum(int a[], int s, int e, int max){
		if (s>e) return Integer.MIN_VALUE; 
		if (s==e) return a[s]; 
		int mid = (s+e)/2; 
		int leftMax = maxSum(a, s, mid-1, max); 
		int rightMax = maxSum(a, mid+1, e, max); 
		int maxSum = Math.max(leftMax, Math.max(rightMax, max)); 
		int sum = 0; 
		leftMax = 0; 
		for (int i=mid-1; i>=s; i--) {
			sum += a[i]; 
			if (sum>leftMax) leftMax= sum; 
		}
		sum=0; rightMax = 0; 
		for (int i=mid+1; i<=e; i++) {
			sum +=a[i]; 
			if (sum>rightMax) rightMax = sum; 
		}
		maxSum = Math.max(maxSum, leftMax+a[mid]+rightMax); 
		return maxSum; 
	}
}

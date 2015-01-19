package question61_90;

public class MedianOfTwoSortedArray {
	public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length; 
        int n = B.length; 
        int i=0, j=0, index=0; 
        int[] a = new int[m+n]; 
        while (i<m && j<n) {
            if (i<m &&A[i]<=B[j]) {
                a[index++] = A[i++]; 
                if (i==m ) break; 
            } 
            if (j<n && B[j]<=A[i]) {
                a[index++] = B[j++]; 
            }
        }
        if (i==m) {
            while(j<n) a[index++] = B[j++]; 
        } else if (j==n) {
            while(i<m) a[index++] = A[i++]; 
        }
        if ((m+n)%2==0) return ((double)(a[(m+n)/2-1]) + (double) (a[(m+n)/2]))/2; 
        return (double)a[(m+n)/2]; 
    }
	
	public static void main(String[] args){
		int[] A = new int[]{}; 
		int[] B = new int[]{2,3}; 
		System.out.println(findMedianSortedArrays(A, B)); 
	}
}

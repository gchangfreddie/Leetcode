package First30;

public class MedianOfTwoSortedArray {
	public static double findMedianSortedArrays1(int A[], int B[]) {
        int m=A.length, n=B.length; 
        if ((m+n)%2==0) 
            return (findKth(A, 0, m-1, B, 0, n-1, (m+n)/2-1) + 
            		findKth(A, 0, m-1, B, 0, n-1, (m+n)/2))*0.5; 
        else return (findKth(A, 0, m-1, B, 0, n-1, (m+n)/2))*1.0;
    }
    
    public static int findKth(int[] a, int m1, int m2, int[] b, int n1, int n2, int index){
    	 int m = m2-m1+1, n=n2-n1+1; 
         if (m==0) 
        	 return b[n1+index]; 
         if (n==0) 
        	 return a[m1+index]; 
         if (index==0) 
        	 return Math.min(a[m1], b[n1]); 
         //always assume that m is equal or smaller than n  
         if (m>n) return findKth(b, n1, n2, a, m1, m2, index); 
         int am = Math.min((index+1)/2, m), bm = index+1-am; 
         int ai = m1 + am-1, bi= n1 + bm-1; 
         if (a[ai]<b[bi]) return findKth(a, ai+1, m2, b, n1, bi, index-am); 
         else if (a[ai]>b[bi]) return findKth(a, m1, ai, b, bi+1, n2, index-bm); 
         else return a[ai]; 
    }
	 
	public static int findKth(int A[], int B[], int k, 
		int aStart, int aEnd, int bStart, int bEnd) {
	 
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
	 
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
	 
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
	
	public static void main(String[] args) {
//		int[] a = {1,2,4,5,9,10}; 
//		int[] b = {13,16,18,113}; 
		
		int[] a = {1, 2}; 
		int[] b = {1, 2}; 
		
		System.out.println(findMedianSortedArrays1(a, b));
	}

}

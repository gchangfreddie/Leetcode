package question31_60;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] a, int target) {
        if (a==null || a.length==0) return false; 
        int offset = 0, len = a.length;
        for (;offset<len-1; offset++) {
            if (a[offset+1]<a[offset]) break;
        }
        if ((len==1) || (offset==len-1 && (a[offset-1]<=a[offset])))
        	offset = 0;
        else offset++; 
        return search(a, target, 0, len-1, offset); 
    }
    
    public boolean search(int[] a, int target, int start, int end, int offset) {
        if (start>end) return false; 
        int mid = (start+end)/2; 
        int m = convert(mid, offset, a.length); 
        if (a[m]==target) return true; 
        else if (a[m]>target) return search(a, target, start, mid-1, offset); 
        else return search(a, target, mid+1, end, offset); 
    }
    
    public int convert(int index, int offset, int len) {
        return (index+offset)%len; 
    }
    
    public boolean search1(int[] A, int target) {
        int i=0, j=A.length-1; 
        while(i<=j) {
            int m = i+(j-i)/2; 
            if (A[m]==target) return true; 
            if (A[i]<A[m]){
                if (target<A[m] && target>=A[i]) j=m-1; 
                else i=m+1;
            } else if (A[i]>A[m]) {
                if (target>=A[i] || target<A[m]) j=m-1;
                else i=m+1;
            } else {
                i++; 
            }
        }
        return false; 
    }
    
    public static void main(String[] args) {
    	int[] a = new int[] {1, 3, 4, 0}; 
    	SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII(); 
    	System.out.println(s.search(a, 4));
    }
}

package question31_60;

public class SearchInRotatedSortedArray {
    public int search1(int[] A, int target) {
        if (A.length==0) return -1; 
        int pivot=0; 
        for (int i=0; i<A.length-1; i++) {
            if (A[i]>A[i+1]) {
                pivot=i+1;
                break;
            }    
        }
        return search(A, 0, A.length-1, pivot, target); 
    }
    
    public int search(int[] a, int s, int e, int pivot, int target){
        if (s>e) return -1; 
        int m=s+(e-s)/2; 
        int mid=(m+pivot)%a.length; 
        if (a[mid]==target) return mid;
        else if (a[mid]<target) return search(a, m+1, e, pivot, target); 
        else return search(a, s, m-1, pivot, target); 
    }
    
    public static void main(String[] args) {
    	int[] a = new int[] {3,1}; 
    	SearchInRotatedSortedArray s = new SearchInRotatedSortedArray(); 
    	System.out.println(s.search1(a, 1));
    }
    
}

package leetCode.sortAndSearch;

public class SearchInRotatedSortedArray {
    public int search1(int[] A, int target) {
    	if (A.length==0) return -1; 
        int l=0, h=A.length-1; 
        // Either the left or right half must be normally ordered.
        // find out which side is normally ordered. and then use the normally ordered half to figure out which side to search.
        while(l<=h){
            int m=l+(h-l)/2; 
            if(A[m]==target) return m; 
            if (A[m]<=A[h]){
                if (target<=A[h] && target>A[m]) l=m+1;
                else h=m-1; 
            } else {
                if (target>=A[l] && target<A[m]) h=m-1;
                else l=m+1; 
            }
        }
        return -1; 
    }
    
    public static void main(String[] args) {
    	int[] a = new int[] {3,1}; 
    	SearchInRotatedSortedArray s = new SearchInRotatedSortedArray(); 
    	System.out.println(s.search1(a, 1));
    }
}
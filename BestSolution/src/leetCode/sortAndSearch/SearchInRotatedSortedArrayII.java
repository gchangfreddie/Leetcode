package leetCode.sortAndSearch;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
        if (A.length==0) return false;
        int left=0, right=A.length-1; 
        while(left<=right){
            int m=left+(right-left)/2;
            if (A[m]==target) return true; 
            if (A[m]<A[right]){ //right side is ordered
                if (target>A[m] && target<=A[right]) left=m+1; 
                else right=m-1;
            } else if (A[m]>A[right]) { // left side is ordered
                if (target<A[m] && target>=A[left]) right=m-1; 
                else left=m+1; 
            } else {
                if (A[left]!=A[m]) { //left side is ordered
                    right=m-1; 
                } else {
                    right--; 
                }
            }
        }
        return false; 
    }
	
	public static void main(String[] args) {
    	int[] a = new int[] {2,4,5,2,2,2,2}; 
    	int[] b = new int[] {2,2,2,2,4,5,2}; 
    	SearchInRotatedSortedArrayII s = new SearchInRotatedSortedArrayII(); 
    	System.out.println(s.search(a, 1));
    }
}

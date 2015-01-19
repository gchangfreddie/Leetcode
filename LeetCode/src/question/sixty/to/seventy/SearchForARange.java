package question.sixty.to.seventy;

public class SearchForARange {
	public int[] searchRangeMe(int[] A, int target) {
        int[] res = new int[]{-1, -1}; 
        if (A==null || A.length==0) return res; 
        return search(A, 0, A.length-1, target); 
    }
    
    public int[] search(int[] a, int start, int end, int target) {
        if (start > end) return new int[]{-1, -1}; 
        int mid = (start+end)/2; 
        if (a[mid]==target) {
            int e=mid, s=mid;
            int i=mid+1; 
            for (; i<=end; i++) {
                if (a[i]!=target) break;
            }
            if (i<=end && a[i]==target) e=end; else e=i-1;
            i=mid-1; 
            for (; i>=start; i--) {
                if (a[i]!=target) break;  
            }
            if (i>=start && a[i]==target) s=end; else s=i+1;
            return new int[]{s, e}; 
        } else if (a[mid]<target) {
            return search(a, mid+1, end, target); 
        } else {
            return search(a, start, mid-1, target); 
        }
    }
    
//    public int[] searchRange(int[] A, int target) {
//        if (A==null || A.length==0) return new int[]{}; 
//        int left = searchRangeLeft(A, target, 0, A.length-1); 
//        if (left== -1) return new int[] {-1,-1}; 
//        int right = searchRangeRight(A, target, 0, A.length-1);  
//        return new int[]{left, right}; 
//    }
    
    public int searchRangeLeft(int[] a, int target, int start, int end) {
        if (start>end) return -1; 
        if (target == a[start]) return start;
        int mid = (start+end)/2; 
        if (target==a[mid]) return searchRangeLeft(a, target, start+1, mid); 
        if (target<a[mid]) return searchRangeLeft(a, target, start+1, mid-1); 
        else return searchRangeLeft(a, target, mid+1, end); 
    }
    
    public int searchRangeRight(int[] a, int target, int start, int end) {
        if (start>end) return -1; 
        if (target == a[end]) return end;
        int mid = (start+end)/2; 
        if (target==a[mid]) return searchRangeRight(a, target, mid, end-1); 
        if (target<a[mid]) return searchRangeRight(a, target, start, mid-1); 
        else return searchRangeRight(a, target, mid+1, end-1); 
    }
    
    public int[] searchRange(int[] A, int target) {
        if (A==null || A.length==0) return new int[]{}; 
        int left = searchRangeMaxLessThan(A, target, 0, A.length-1); 
        int right = searchRangeMaxLessThan(A, target+1, 0, A.length-1);
        if (left==right) return new int[]{-1,-1}; 
        else return new int[]{left+1, right}; 
    }
    
    public int searchRangeMaxLessThan(int[] a, int target, int start, int end) {
        if (start>end) return (a[start]<target) ? start : start-1; 
        if (a[end]<target) return end; 
        int mid = (start+end)/2; 
        if (target<=a[mid]) return searchRangeMaxLessThan(a, target, start, mid-1); 
        else  
        	return  searchRangeMaxLessThan(a, target, mid+1, end-1);
    }
    // this is code from web
    public int searchMaxLessThan(int[] A, int target, int start, int end){
        
        if(start==end) return A[start]<target?start:start-1;
        if(start==end-1) return A[end]<target?end:(A[start]<target?start:start-1);
        //the above guarantee following has at least 3 elements. so will not have index out of bound error
        
        int mid = (start+end)/2;
        if(A[mid]>=target){
            end=mid-1;// we are looking for the less than, so will exclude mid
        }else{
            start=mid;
        }
        return searchMaxLessThan(A,target,start,end);
    }
    
    public static void main(String[] args){
    	SearchForARange sf = new SearchForARange(); 
//    	int leftIndex = sf.searchRangeLeft(new int[]{1, 4, 4, 4, 5, 6, 8, 8, 8, 10 }, 9, 0, 9 ); 
//    	System.out.println(leftIndex);
    	int[] res = sf.searchRange(new int[]{1,11}, 9); 
    	System.out.println(res[0] + "  " +res[1]);
    	System.exit(0);
    }
}

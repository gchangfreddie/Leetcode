package leetCode.sortAndSearch;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int[] res = new int[]{-1, -1}; 
		if (A==null || A.length==0) return res; 
		int i1 = searchLeft(A, target, 0, A.length-1); 
		int i2 = searchRight(A, target, 0, A.length-1); 
		return new int[]{i1, i2}; 
	}

	public int searchLeft(int[] a, int target, int s, int e){
		if (s>e) return -1; 
		int m= (s+e)/2; 
		if (target<=a[m]) {
			int res = searchLeft(a, target, s, m-1); 
			return res==-1 ? target==a[m] ? m : res : res;
		} else {
			return searchLeft(a, target, m+1, e); 
		}
	}
	
	public int searchRight(int[] a, int target, int s, int e){
		if (s>e) return -1; 
		int m= (s+e)/2; 
		if (target>=a[m]) {
			int res = searchRight(a, target, m+1, e); 
			return res==-1 ? target==a[m] ? m : res : res;
		} else {
			return searchRight(a, target, s, m-1); 
		}
	}
	
	public static void main(String[] args){
		SearchForARange sfr = new SearchForARange(); 
		int[] res = sfr.searchRange(new int[]{1}, 0);
		for (int i: res) System.out.println(i);
	}
}

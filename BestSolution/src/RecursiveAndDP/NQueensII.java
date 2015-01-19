package RecursiveAndDP;

public class NQueensII {
	public int totalNQueens(int n) {
		if (n==0) return 0;
		int[] a = new int[n]; 
		return putQ(0, n, a); 
	}
	
	private int putQ(int s, int end, int[] a) {
		if (s==end) {
			return 1; 
		}
		int res=0; 
		for (int i=0; i<end; i++) {
			a[s] = i; 
			if (noConflict(a, s)) {
				res += putQ(s+1, end, a);
			}
		}
		return res; 
	}
	
	private boolean noConflict(int[] a, int s) {
		for (int i=0; i<s;i++) {
			if (a[i]==a[s] || (Math.abs(a[i]-a[s]) == (s-i))) 
				return false; 
		}
		return true; 
	}
	
	public static void main(String[] args) {
		NQueensII na = new NQueensII();
		System.out.println(na.totalNQueens(8));
	}
}

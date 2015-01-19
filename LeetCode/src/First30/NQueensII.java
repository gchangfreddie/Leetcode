package First30;

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
	
	 public int totalNQueens1(int n) {
	        if (n==0) return 0; 
	        return total(n, 0, new int[n]); 
	    }
	    
	    public int total(int n, int row, int[] a){
	        if (n==row) 
	        	return 1; 
	        int res=0; 
	        for (int i=0; i<n; i++){
	        	a[row]=i; 
	            if (isValid(a, n, i, row)){
	                res+=total(n, row+1, a); 
	            }
	        }
	        return res;
	    }
	    
	    public boolean isValid(int[] a, int n, int index, int row){
	        for (int i=0;i<row; i++){
	            if (a[i]==a[row] || Math.abs(a[row]-a[i])==(row-i)) return false; 
	        }
	        return true; 
	    }
	
	public static void main(String[] args) {
		NQueensII na = new NQueensII();
		System.out.println(na.totalNQueens1(4));
	}
}

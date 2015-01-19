package question31_60;

public class UniquePath {
	public int uniquePaths(int m, int n) {
        if (m==0 && n==0) return 0; 
        return allPath(0, 0, m, n); 
    }
    
    public int allPath(int i, int j, int m, int n) {
        if (i==(m-1) && j==(n-1)) return 1; 
        else {
            int res = 0; 
            if (i<(m-1)) 
            	res += allPath(i+1, j, m, n) ; 
            if (j<(n-1))
            	res+= allPath(i, j+1, m,n); 
            return res; 
        }
    }
    
    public static void main(String[] args) {
    	UniquePath up = new UniquePath(); 
    	System.out.println(up.uniquePaths(23, 12));
    }
}

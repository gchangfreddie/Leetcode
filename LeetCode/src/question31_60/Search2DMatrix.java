package question31_60;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null) return false; 
        int m = matrix.length, n = matrix[0].length; 
        return binarySearch(matrix, 0, m*n-1, n, target); 
    }
    
    public boolean binarySearch(int[][] matrix, int s, int e, int m, int target) {
        if (s>e) return false;
        int mid = (s+e)/2; 
        int x = mid/m, y = mid%m; 
        if (matrix[x][y]==target) return true; 
        if (matrix[x][y]<target) return binarySearch(matrix, mid+1, e, m, target); 
        else return binarySearch(matrix, s, mid-1, m, target); 
    }
    
    public static void main(String[] args) {
    	int[][] matrix = new int[][]{{1,1}}; 
    	Search2DMatrix sm = new Search2DMatrix(); 
    	System.out.println(sm.searchMatrix(matrix, 2)); 
    }
}

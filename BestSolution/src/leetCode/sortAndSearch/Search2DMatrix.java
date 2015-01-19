package leetCode.sortAndSearch;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length==0 || matrix[0].length==0) return false; 
		int m=matrix.length, n=matrix[0].length, h = m*n-1, l=0; 
		while (l<=h) {
			int mid =(l+h)/2; 
			int row = mid/n, col = mid%n; 
			if (matrix[row][col]==target) return true;
			else if (matrix[row][col]>target) h=mid-1; 
			else l=mid+1; 
		}
		return false;
	}
}

package leetCode.arrayString;

public class SetZeros {
	public static void setZeroes(int[][] matrix) {
		if (matrix==null || matrix.length==0 || matrix[0].length==0) return; 
        boolean firstRow = false, firstCol = false;
        int m=matrix.length, n=matrix[0].length; 
        for (int i=0; i<m; i++) {
            if (matrix[i][0]==0) { firstCol=true; break; }
        }
        for (int i=0; i<n; i++) {
            if (matrix[0][i]==0) { firstRow=true; break; }
        }
        for (int i=1;i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0]=0; matrix[0][j]=0;
                }
            }
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0; 
            }
        }
        if (firstRow){
            for (int i=0; i<n; i++) matrix[0][i]=0; 
        }
        if (firstCol) {
            for (int i=0; i<m; i++) matrix[i][0]=0; 
        }
	}
	
	public static void main(String[] args){
		int[][] array = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}}; 
		setZeroes(array);
		for (int i=0; i<array.length; i++) {
			for (int in : array[i]){
				System.out.print(in + " ");
			}
			System.out.println();
		}
	}
}

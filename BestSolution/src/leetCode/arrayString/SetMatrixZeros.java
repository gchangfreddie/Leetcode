package leetCode.arrayString;

public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0 ) return ; 
        boolean firstRow=false, firstCol = false; 
        int m=matrix.length, n=matrix[0].length; 
        for (int i=0; i<n; i++) {
            if (matrix[0][i]==0) {
                firstRow=true; 
                break;
            }
        }
        for (int j=0; j<m; j++) {
            if (matrix[j][0]==0) {
                firstCol=true; 
                break; 
            }
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0]=0; 
                    matrix[0][j]=0; 
                }
            }
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) 
                if (matrix[i][0]==0|| matrix[0][j]==0) matrix[i][j]=0; 
        }
        if (firstRow) {
            for (int i=0; i<n; i++) matrix[0][i]=0; 
        }
        if (firstCol) {
            for (int j=0; j<m; j++) matrix[j][0]=0;
        }
	} 
	
	public static void main(String[] args){
		SetMatrixZeros smz = new SetMatrixZeros();
		int[][] a = new int[][]{{1,1,1},{1,1,0}}; 
		smz.setZeroes(a);
	}
	
}

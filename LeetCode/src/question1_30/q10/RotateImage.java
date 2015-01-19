package question1_30.q10;

public class RotateImage {
	    public void rotate(int[][] matrix) {
	        if(matrix==null) return ; 
	        int n = matrix.length; 
	        int layer = 0, offset=0; 
	        while (layer <=(n/2-1)){
	            int s=layer, e = n-1-layer; 
	            for (int i=0; i<e-offset; i++) {
	                int temp = matrix[s][s+i];
	                matrix[s][s+i] = matrix[e-i][s]; 
	                matrix[e-i][s] = matrix[e][e-i];
	                matrix[e][e-i] = matrix[s+i][e]; 
	                matrix[s+i][e] = temp; 
	            }
	            layer++; offset++; 
	            print(matrix); 
	            System.out.println();
	        }
	    }
	    
	    
	    public static void main(String[] args){
	    	RotateImage ri = new RotateImage(); 
	    	int[][] matrix = new int[][]{{1,2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13,14,15,16}};
//	    	int[][] matrix = new int[][]{{1,2}, {3,4}};
//	    	int[][] matrix = new int[][]{{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},{33,1,20,7,21,7},{4,24,1,6,32,34}};
	    	ri.rotate1(matrix);
	    	
	    	print(matrix);
	    }
	    
	    public void rotate1(int[][] matrix) {
	        if (matrix.length<=1) return; 
	        int n=matrix.length; 
	        int layer = 0;
	        while(layer<n/2) {
	        	int first = layer, last = n-1-layer; 
	            for (int i=first; i<last; i++) {
	            	int offset = i-layer; 
	                int temp = matrix[first][i]; 
	                matrix[first][i] = matrix[last-offset][first]; 
	                matrix[last-offset][first] = matrix[last][last-offset]; 
	                matrix[last][last-offset] = matrix[i][last]; 
	                matrix[i][last] = temp;
	            }
	            layer++; 
	        }
	    }

		private static void print(int[][] matrix) {
			for (int i=0; i<matrix.length; i++) {
	    		for (int j=0; j<matrix.length; j++){
	    			System.out.print("   " + matrix[i][j]);
	    		}
	    		System.out.println();
	    	}
		}
}

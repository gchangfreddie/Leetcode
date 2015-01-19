package question31_60;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer> (); 
        if (matrix == null || matrix.length==0) return res; 
        int layer = 0, m=matrix.length, n= matrix[0].length;  
        while(layer<Math.min(m-layer, n-layer)){
            // top
            for (int i=layer; i<n-layer; i++) {
                res.add(matrix[layer][i]);
            }
            //right
            for (int i=layer+1; i<m-layer-1; i++){
                res.add(matrix[i][n-layer-1]);
            }
            //bottom
            if ((m-layer-1) != layer) {
	            for (int i=n-layer-1; i>=layer; i--) {
	            		res.add(matrix[m-layer-1][i]); 
	            }
            }
            //left
            if (layer!=n-layer-1) {
	            for (int i=m-layer-2; i>layer; i--) {
	            		res.add(matrix[i][layer]); 
	            }
            }
            layer++; 
        }
        return res; 
    }
	
	public static ArrayList<Integer> spiralOrder1(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>(); 
		if (matrix==null || matrix.length==0||matrix[0].length==0) return res; 
		spiralMatrix(matrix, 0, 0, matrix.length, matrix[0].length, res); 
		return res;
	}
	
	public static void spiralMatrix(int[][] matrix, int r, int c, int m, int n, ArrayList<Integer> res) { 
		// basic case
		if (m<=r || n<=c) return ; 
		if (m-r==1) {
			for (int i=c; i<n; i++) 
				res.add(matrix[r][i]); 
			return ;
		}
		if (n-c==1) {
			for(int i=r; i<m; i++) res.add(matrix[i][c]); 
			return; 
		}
		//normal case 
		for (int i=c; i<n; i++) {
			res.add(matrix[r][i]); 
		}
		for (int i=r+1; i<m-1; i++) {
			res.add(matrix[i][n-1]); 
		}
		for (int i=n-1; i>c; i--) {
			res.add(matrix[m-1][i]); 
		}
		for (int i=m-1; i>r; i--) {
			res.add(matrix[i][c]); 
		}
		if (m==1 || n==1) {
			spiralMatrix(matrix, r+1, c+1, 1, 1, res); 
		}
		spiralMatrix(matrix, r+1, c+1, m-1, n-1, res); 
	}

	 public static ArrayList<Integer> spiralOrder(int [][] matrix, int x, int y, int m, int n){
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        if(m<=0||n<=0) return res;
	        if(m==1&&n==1) {
	            res.add(matrix[x][y]);
	            return res;
	        }
	        for(int i=0;i<n-1;i++){
	            res.add(matrix[x][y++]);
	        }
	        for(int i=0;i<m-1;i++){
	            res.add(matrix[x++][y]);
	        }
	        if(m>1){    
	            for(int i=0;i<n-1;i++){
	                res.add(matrix[x][y--]);
	            }
	        }
	        if(n>1){
	            for(int i=0;i<m-1;i++){
	                res.add(matrix[x--][y]);
	            }
	        }
	        if(m==1||n==1)
	            res.addAll(spiralOrder(matrix,x,y,1,1));
	        else    
	            res.addAll(spiralOrder(matrix,x+1,y+1,m-2,n-2));
	        return res;
	    }
	public static void main(String[] args) {
//		ArrayList<Integer> res = spiralOrder1(new int[][]{{1,2,3,3,2,1},{4,5,6, 6,5,4},{7,8,9, 9,8,7}});
		List<Integer> res1 = spiralOrder11(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13}});
		List<Integer> res = spiralOrder11(new int[][]{{2,3}});
		System.out.println(res1);
		
	}
	
	public static List<Integer> spiralOrder11(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>(); 
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return res; 
        int layer=0, m=matrix.length, n=matrix[0].length; 
        while (layer<=Math.min(m/2, n/2)){
            int s=layer, er=m-layer-1, ec=n-layer-1;
            for (int i=s; i<=ec; i++) res.add(matrix[s][i]); 
            for (int i=s+1; i<er; i++) res.add(matrix[i][ec]); 
            if (er!=s)
                for (int i=ec; i>=s; i--) res.add(matrix[er][i]); 
            if (ec!=s)
                for (int i=er-1; i>s; i--) res.add(matrix[i][s]); 
            layer++; 
        }
        return res; 
    }
}

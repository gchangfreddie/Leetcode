package question1_30.q10;

import java.util.*;

public class SprialMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n]; 
        int layer=0, index=1; 
        while(layer<=n/2) {
            int s=layer, e=n-1-layer; 
            for (int j=s; j<=e; j++) res[s][j]=index++; 
            for (int j=s+1; j<e; j++) res[j][e]=index++; 
            if (s!=e) for (int j=e; j>=s; j--) res[e][j]=index++; 
            if (s!=e) for (int j=e-1; j>s; j--) res[j][s]=index++; 
            layer++; 
        }
        return res; 
    }
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>(); 
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return res; 
        int layer=0, m=matrix.length, n=matrix[0].length; 
        while (layer<Math.min(m-layer, n-layer)){
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

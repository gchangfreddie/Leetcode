package question1_30.q10;

public class SprialMatrix {
	
	public static int[][] generateMatrix(int n) {
        int[][] b = new int[n][n]; 
        if(n==0) return b; 
        int l =0, i=1;
        while(i<=n*n) {
            for (int k=l; k<n-l && i<=n*n; k++) {
                b[l][k] = i++; 
            }
            for (int k=l+1; k<n-l-1 && i<=n*n; k++) {
                b[k][n-1-l] = i++; 
            }
            for (int k=n-l-1; k>l && i<=n*n; k--) {
                b[n-1-l][k] = i++; 
            }
            for (int k=n-1-l; k>l && i<=n*n; k--) {
                b[k][l] = i++; 
            }
            l++; 
        }
        return b; 
    }
	
	public static int[][] generateMatrix1(int n) {
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
	
	public static void main(String[] args){
		int[][] a = generateMatrix1(3);
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].length; j++)
				System.out.print(" " + a[i][j]);
			System.out.println();
		}
		System.exit(0);
	}
}

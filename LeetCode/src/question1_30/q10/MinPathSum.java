package question1_30.q10;

public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int m=grid.length-1, n=grid[0].length-1; 
        int[][] sum = new int[m+1][n+1];
        sum[0][0]=grid[0][0];
        for (int i=1; i<=m; i++){
            sum[i][0]=sum[i-1][0]+grid[i][0]; 
        }
        for (int i=1; i<=n; i++) {
            sum[0][i]=sum[0][i-1]+grid[0][i]; 
        }
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                sum[i][j]=Math.min(sum[i-1][j], sum[i][j-1])+grid[i][j]; 
            }
        }
        return sum[m][n]; 
    }
    
    public static void main(String[] args) {
    	System.out.println(minPathSum(new int[][]{{1}}));
    }
}

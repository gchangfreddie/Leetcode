package question1_30.q10;

public class UniquePathII {
	public int uniquePathsWithObstacles(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0; 
        int m = grid.length, n =  grid[0].length; 
        if (grid[m-1][n-1]==1) return 0; 
        int[][] max = new int[m][n]; 
        for (int i=0; i<m; i++)
        for (int j=0; j<n; j++)
        max[i][j] = -1;
        return path(0, 0, grid, grid.length, grid[0].length, max); 
    }
    
    public int path(int x, int y, int[][] a, int m, int n, int[][] max) {
    	 if (max[x][y] != -1) return max[x][y]; 
         if (a[x][y]==1) return 0; 
         if (x==m-1 && y==n-1) return 1; 
         max[x][y] = 0; 
         if (x==m-1) max[x][y] += path(x, y+1, a, m, n, max); 
         else if (y==n-1) max[x][y] += path(x+1, y, a, m, n, max); 
         else max[x][y] = path(x+1, y, a, m, n, max) + path(x, y+1, a, m, n, max); 
         return max[x][y]; 
    }
    
    public static void main(String[] args) {
    	UniquePathII p = new UniquePathII(); 
    	int[][] grid = new int[][]{{0, 0}}; 
    	System.out.println(p.uniquePathsWithObstacles(grid)); 
    	
    }
}

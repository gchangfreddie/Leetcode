package RecursiveAndDP;

import java.util.*;
import java.awt.*;
public class UniquePath {
	public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n]; 
        dp[0][0]=1; 
        for (int i=1; i<m; i++) dp[i][0]=1; 
        for (int j=1; j<n; j++) dp[0][j]=1; 
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1]; 
    }
	
	public void uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length; 
        ArrayList<Point> list = new ArrayList<Point>(); 
        foo(obstacleGrid, m, n, list, 0, 0); 
    }
	
	public void foo(int[][] grid, int m, int n, ArrayList<Point> list, int x, int y) {
		if (x==m && y==n) {
			System.out.println(list);
		}
		if (grid[x][y]==1) return; 
		Point p = new Point(x, y); 
		ArrayList<Point> newList = new ArrayList<Point>(list); 
		newList.add(p); 
		foo(grid, m, n, newList, x+1, y) ;
		foo(grid, m, n, newList, x, y+1); 
	}
}

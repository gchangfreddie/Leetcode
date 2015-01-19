package question.sixty.to.seventy;

import java.util.*;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if(board==null || board.length==0 || board[0].length==0) return; 
        int m=board.length, n=board[0].length; 
        LinkedList<Point> list = new LinkedList<Point>(); 
        for (int i=0; i<n; i++) {
            if (board[0][i]=='O')  list.add(new Point(0, i)); 
            if (board[m-1][i]=='O') list.add(new Point(m-1, i)); 
        }
        
        for (int i=1; i<m-1; i++) {
            if (board[i][0]=='O') list.add(new Point(i, 0)); 
            if (board[i][n-1]=='O') list.add(new Point(i, n-1)); 
        }
        
        while (!list.isEmpty()) {
            Point p = list.poll(); 
            board[p.x][p.y]='y'; 
            if (p.x>0 && board[p.x-1][p.y]=='O') list.add(new Point(p.x-1, p.y)); 
            if (p.x<m-1 && board[p.x+1][p.y]=='O') list.add(new Point(p.x+1, p.y)); 
            if (p.y>0 && board[p.x][p.y-1]=='O') list.add(new Point(p.x, p.y-1)); 
            if (p.y<n-1 && board[p.x][p.y+1]=='O') list.add(new Point(p.x, p.y+1)); 
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j]=='y') board[i][j]='O'; 
                else board[i][j]='X'; 
            }
        }
    }
    
    public class Point{
        int x, y; 
        
        public Point(int a, int b) {
            x=a;
            y=b; 
        }
    }
    
    public static void main(String[] args) {
    	SurroundedRegions sr = new SurroundedRegions(); 
    	char[][] board = new char[][]{"xxxx".toCharArray(), "xoox".toCharArray(), "xxox".toCharArray(), "xoxx".toCharArray()}; 
    	sr.solve(board);
    	System.out.println(board);
    }
}

package question101_150;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board==null || board.length <=2 || board[0].length <=2) return ;
		for (int i=0; i<board[0].length; i++) {
			if (board[0][i] == 'O')  {
				dfs(board, 0, i); 
			}
			if (board[board.length-1][i]=='O') {
				dfs(board, board.length -1, i); 
			}
		}
		for (int i=0; i<board.length; i++) {
			if (board[i][0] == 'O')  {
				dfs(board, i, 0); 
			}
			if (board[i][board[0].length-1]=='o') {
				dfs(board, i, board[0].length-1); 
			}
		}
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if (board[i][j]=='O') board[i][j]='X'; 
				else if (board[i][j]=='#') board[i][j] = 'O'; 
			}
		}
		
	}
	
	public void dfs(char[][] board, int i, int j) {
		if (i<0 || j<0 || i==board.length || j== board[0].length) return;
		board[i][j]='#'; 
		if (j<board[0].length-1 && board[i][j+1]=='O') dfs(board, i, j+1); 
		if (i<board.length-1 && board[i+1][j]=='O') dfs(board, i+1, j); 
		if (i>0 && board[i-1][j]=='O') dfs(board, i-1, j);
		if (j>0 && board[i][j-1]=='O') dfs(board, i, j-1); 
	}
	
	public static void main(String[] args) {
		char[][] board = new char[3][3]; 
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++) {
				board[i][j] = 'O'; 
			}
		SurroundedRegions sr = new SurroundedRegions(); 
		sr.solve(board); 
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(board[i][j]); 
			}
			System.out.println();
		}	
	}
}

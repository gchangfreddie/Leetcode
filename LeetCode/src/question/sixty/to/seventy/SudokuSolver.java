package question.sixty.to.seventy;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        solve(board, 0, 0); 
    }
    
    public boolean solve(char[][] board, int r, int c) {
        if (r==8 && c==9)
        	return true; 
        if (c==9) {
            r++; 
            c=0; 
        }
        while(board[r][c]!='.') {
        	c++; 
        	if (c==9) {r++; c=0;}
        	if (r==9) return true;
        }
        if (board[r][c]=='.') {
            for (char i='1'; i<='9'; i++) {
                if (valid(board, r, c, i)) { 
                    board[r][c]=i;
                    if (solve(board, r, c+1)) return true;
                    board[r][c]='.'; 
                }    
            }
        }
        return false;
    }
    
    public boolean valid(char[][] board, int r, int c, char v) {
        for (int i=0; i<9; i++) {
            if (board[i][c]==v) return false; 
        } 
        for (int i=0; i<9; i++) {
            if (board[r][i]==v) return false;
        }
        for (int i=r/3*3; i<r/3*3+3; i++) {
            for (int j=c/3*3; j<c/3*3+3; j++) {
                if (board[i][j]==v) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
		String[] s = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] c = new char[9][9]; 
		int i=0; 
		for (String str : s) {
			for (int j=0; j<9; j++) {
				c[i][j] = str.charAt(j); 
			}
			i++; 
		}
		SudokuSolver ss = new SudokuSolver(); 
		ss.solveSudoku(c); 
		for (int ii=0; ii<9; ii++) {
			System.out.println(c[ii]);
		}
	}
}

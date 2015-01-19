package RecursiveAndDP;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        solve(board, 0, 0); 
    }
    
    public boolean solve(char[][] board, int i, int j){
        if (j==9) {
            i++; j=0;
        }
        if (i==9) return true;
        
        if (board[i][j]=='.') {
            for (char c='1'; c<='9'; c++){
                if (isValid(board, i, j, c)) {
                    board[i][j]=c;
                    if (solve(board, i, j+1)) return true; 
                }    
             }
             board[i][j]='.'; 
             return false;
        } else {
           return solve(board, i, j+1);        
        }
    }
    
    public boolean isValid(char[][] board, int x, int y, char c){
        for (int i=0; i<9; i++) {
            if (board[x][i]==c || board[i][y]==c) return false; 
        }
        int xs=x/3*3, ys=y/3*3;
        for (int i=xs; i<xs+3; i++) {
            for (int j=ys; j<ys+3; j++) {
                if (board[i][j]==c) return false;
            }
        }
        return true;
    }
}

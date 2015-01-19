package leetCode.arrayString;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        if (board==null || board.length!=9 || board[0].length!=9) return false; 
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j]=='.') continue; 
                char c = board[i][j]; 
                for (int k=i+1; k<9; k++) {
                    if (board[k][j]==c) return false; 
                }
                for (int k=j+1; k<9; k++) {
                    if (board[i][k]==c) return false;
                } 
                int xs=i/3*3, ys=j/3*3; 
                for (int k=xs; k<xs+3; k++) {
                    for (int m=ys; m<ys+3; m++){
                        if (k==i && m==j) continue; 
                        if (board[k][m]==c) return false; 
                    }
                }
            }
        }
        return true; 
    }
}

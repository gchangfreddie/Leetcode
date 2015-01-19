package question1_30.q10;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
        int row = board.length, col=row; 
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                char v = board[i][j]; 
                if (v=='.') continue;
                for (int m=i+1; m<row; m++) {
                    if (board[m][j]==v) return false; 
                }
                for (int m=j+1; m<col; m++) {
                    if (board[i][m]==v) return false; 
                }
                int s=(i/3)*3, s1=(j/3)*3; 
                for (int m=s; m<s+3; m++) {
                    for (int k=s1; k<s1+3; k++) {
                        if(board[m][k]==v && m!=i && k!=j) 
                        	return false;
                    }
                }
            }
        }
        return true; 
    }
	
	public static void main(String[] args) {
		String[] s = new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char[][] c = new char[9][9]; 
		int i=0; 
		for (String str : s) {
			for (int j=0; j<9; j++) {
				c[i][j] = str.charAt(j); 
			}
			i++; 
		}
		System.out.println(isValidSudoku(c)); 
	}
}

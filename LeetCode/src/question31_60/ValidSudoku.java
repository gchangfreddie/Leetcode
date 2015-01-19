package question31_60;

import java.util.HashSet;

public class ValidSudoku {
	 public static boolean isValidSudoku(char[][] board) {
	        if (board==null || board.length==0) return false; 
	        HashSet<Integer> hs = new HashSet<Integer>(); 
	        int length = board.length; 
	        for (int i=0; i<length; i++) {
	            for (int j=0; j<length; j++) {
	                if (board[i][j]!='.') {
	                    if (!hs.add(new Integer(board[i][j]))) return false; 
	                }
	            }
	            hs.clear(); 
	        }
	        for (int j=0; j<length; j++) {
	            for (int i=0; i<length; i++) {
	                if (board[i][j]!='.') {
	                    if (!hs.add(new Integer(board[i][j]))) return false; 
	                }
	            }
	            hs.clear(); 
	        }
	        for (int i=0; i<3; i++) {
	            for (int j=0; j<3; j++) {
	                for (int k=0; k<3; k++) {
	                    for (int m=0; m<3; m++) {
	                        if (board[i*3+k][j*3+m]!='.'){
	                            if (!hs.add(new Integer(board[i*3+k][j*3+m]))) return false; 
	                        }
	                    }
	                }
	                hs.clear(); 
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

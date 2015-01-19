package question101_150;

import java.util.*;

public class Sudoku {
	public void solveSudoku(char[][] board) {
		int i=0, j=0; 
		while(board[i][j]!='.') {
			if (j==8) {i++; j=0;} 
			else j++; 
		}
		solveSoduku(board, i, j); 
        
    }
	
	public boolean solveSoduku(char[][] board, int row, int col) {
		if (row==9) return true; 
		for (int i=1; i<=9; i++) {
			if (validate(board, row, col, i)){
				board[row][col]=(char)(i+'0');
				int newRow = col==8 ? row+1 : row; 
				int newCol = col==8 ? 0: col+1; 
				while (newRow<9 && board[newRow][newCol]!='.') {
					if (newCol==8) {newRow++; newCol=0; }
					else newCol++; 
				}
				if (newRow==9) return true;
				if (solveSoduku(board, newRow, newCol)) return true; 
				else board[row][col]='.'; 
			} 
		}
		return false; 
	}
	
	public boolean validate(char[][] board, int row, int col, int num) {
		board[row][col]=(char)(num+'0'); 
		for (int i=0; i<9; i++) {
			if (i!=col && board[row][i]==board[row][col]) {
				board[row][col]='.'; return false; 
			}
		}
		for (int i=0; i<9; i++) {
			if (i!=row && board[i][col]==board[row][col]) 
				{board[row][col]='.'; return false; } 
		}
		for (int i=row/3*3; i<row/3*3+3; i++) {
			for (int j=col/3*3; j<col/3*3+3; j++) {
				if (i!=row && j!=col && board[i][j]==board[row][col]) {
					board[row][col]='.'; return false; 
				}
			}
		}
		return true; 
	}
	
	public static void main(String[] args) {
		char[][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','.'},
				{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
		}; 
		Sudoku sdk = new Sudoku(); 
		sdk.solveSudoku(board); 
		for (int i=0; i<=8; i++) {
			System.out.println(board[i]);
		}
	}
}

package question101_150;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length]; 
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if (exist(0, word, visited, board, i, j))
					return true;  
			}	
		}
		return false; 
	}

	public boolean exist(int index, String word, boolean[][] visited, char[][]board, int row, int col) {
		char c = word.charAt(index); 
		if (board[row][col]==c) {
			if (index==word.length()-1) return true; 
			visited[row][col]=true; 
			if (row<board.length-1 && !visited[row+1][col]) {
				if (exist(index+1, word, visited, board, row+1, col)) 
					return true; 
			}
			if (row>0 && !visited[row-1][col]) {
				if (exist(index+1, word, visited, board, row-1, col)) 
					return true; 
			}
			if (col>0 && !visited[row][col-1]) {
				if (exist(index+1, word, visited, board, row, col-1)) 
					return true; 
			}
			if (col<board[0].length-1 && !visited[row][col+1]){
				if (exist(index+1, word, visited, board, row, col+1)) 
					return true; 
			}
			visited[row][col]=false; 
		}
		return false; 
	}
	
	public static void main(String[] args) {
		char[][] board = new char[][]{{'a', 'b', 'c','e'}, {'s','f','c','s'}, {'a','d','e','e'}};
//		char[][] board = new char[][]{{'a'}}; 
		WordSearch ws = new WordSearch(); 
		System.out.println(ws.exist(board, "abcb")); 
	}
}

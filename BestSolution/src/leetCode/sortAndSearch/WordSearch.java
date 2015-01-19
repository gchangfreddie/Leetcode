package leetCode.sortAndSearch;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if (board==null || board.length==0 || board[0].length==0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length]; 
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (dfs(board, 0, i, j, visited, word)) 
                    return true; 
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int d, int i, int j, boolean[][] visited, String word){
        if (word.charAt(d)==board[i][j]){
            if (d==word.length()-1) return true;
            visited[i][j]=true;
            if (i>0 && !visited[i-1][j] && dfs(board, d+1, i-1, j, visited, word)) return true; 
            if (i<board.length-1 && !visited[i+1][j] && dfs(board, d+1, i+1, j, visited, word)) return true;
            if (j>0 && !visited[i][j-1] && dfs(board, d+1, i, j-1, visited, word)) return true;
            if (j<board[0].length-1 && !visited[i][j+1] && dfs(board, d+1, i, j+1, visited, word)) return true;
            visited[i][j]=false;
        }
        return false;
    }
}

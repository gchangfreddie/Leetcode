package question1_30.q10;

import java.util.*;

public class NQueens {
	public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]> (); 
        String[] sa = new String[n]; 
        for (int i=0; i<n; i++){
        	StringBuilder sb = new StringBuilder(n); 
            for (int j=0; j<n; j++){
                sb.append('.'); 
            }
            sa[i]=sb.toString(); 
        }
        solve(n, res, sa, 0); 
        return res;
    }
    
    public void solve(int n, List<String[]> res, String[] sa, int index){
        if (index==n) {
            String[] temp = sa.clone(); 
            res.add(temp); 
        } else {
            for (int i=0; i<n; i++) {
                if (isValid(index, i, sa)){
                    StringBuilder sb = new StringBuilder(sa[index]); 
                    sb.setCharAt(i,'Q'); 
                    String temp = sa[index]; 
                    sa[index]=sb.toString();
                    solve(n, res, sa, index+1); 
                    sa[index]=temp; 
                }
            }
        }
    }
    
    public boolean isValid(int row, int col, String[] board){
        int n = board.length;
        for (int i=0; i<=row-1; i++){
            if (board[i].charAt(col)=='Q') return false;
        }
        for (int i=0; i<=row-1; i++){
            int temp1 = col-(row-i);
            int temp2 = col+(row-i); 
            if (temp1<n&&temp1>=0&&board[i].charAt(temp1)=='Q') return false;
            if (temp2<n&&temp2>=0&&board[i].charAt(temp2)=='Q') return false;
        }
        return true;
    }
    
    public List<String[]> solveNQueens1(int n) {
        List<String[]> res = new ArrayList<String[]>(); 
        if (n==0) return res;
        solve(res, n, 0, new String[n]); 
        return res; 
    }
    
    public void solve(List<String[]> res, int n, int start, String[] s){
        if (n==start) {
            String[] temp = new String[n]; 
            for (int i=0; i<n; i++){
                temp[i]=s[i]; 
            }
            res.add(temp); 
            return; 
        }
        for (int i=0; i<n; i++){
            int j=0; 
            char[] c = new char[n]; 
            while(j<n) {
                c[j]= j==i ? 'Q':'.'; 
                j++; 
            }
            if (isValid(s, i, start, n)){
                s[start]=String.valueOf(c); 
                solve(res, n, start+1, s); 
            }
        }
    }
    
    public boolean isValid(String[] s, int index, int row, int n){
        for (int i=0; i<row; i++) {
            if (s[i].charAt(index)=='Q') return false; 
            
            if (index-row+i>=0 && index-row+i<n && s[i].charAt(index-row+i)=='Q' || 
            		index+row-i>=0 && index+row-i<n && s[i].charAt(index+row-i)=='Q') return false; 
        }
        return true; 
    }
    
    public static void main(String[] args){
    	NQueens q = new NQueens();
    	q.solveNQueens1(4); 
    }
}

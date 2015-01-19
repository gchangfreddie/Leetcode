package question101_150;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxRectangle {
	public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return 0; 
        int m=matrix.length, n = matrix[0].length;
        int res = 0; 
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j]=='1'){
                    int max = maximal(matrix, i, j, m, n); 
                    if (max>res) res = max; 
                }
            }
        }
        return res; 
    } 
    
    public int maximal(char[][] matrix, int row, int col, int m, int n) {
        int max = 1, minWidth=n; 
        for (int i=row; i<m && matrix[i][col]=='1'; i++) {
            int width = 1; 
            for (int j=col+1; j<n&&matrix[i][j]=='1'; j++) width++; 
            if (width<minWidth) minWidth=width; 
            int area = minWidth*(i-row+1); 
            if (area>max) max = area;
        }
        return max; 
    }
    
    public int maximalRectangle1(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return 0 ; 
        int m=matrix.length, n=matrix[0].length; 
        int[][] h = new int[m][n+1]; 
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j]=='1') {
                    h[i][j]= i==0 ? 1 : h[i-1][j]+1;
                }
            }
        }
        int max = 0; 
        for (int i=0; i<m; i++) {
           int area = maximal(h[i]); 
           if (area>max) max = area; 
        }
        return max;
    }
    
    public int maximal(int[] h) {
        Stack<Integer> stack = new Stack<Integer>(); 
        int max = 0, i=0; 
        while (i<h.length) {
           if (stack.isEmpty()|| h[i]>=h[stack.peek()] ) stack.push(i++); 
           else {
               int t = stack.pop(); 
               max = Math.max(max, h[t]*(stack.isEmpty()? i : (i-stack.peek()-1))); 
           }       
        }
        return max; 
    }
	 
	 public static void main(String[] args){
		 char i = 1+'0'; 
		 System.out.println(i);
		 char[][] matrix = new char[1][2]; 
		 matrix[0][0]='0';
		 matrix[0][1]='1'; 
		 MaxRectangle mr = new MaxRectangle(); 
		 System.out.println(mr.maximalRectangle(matrix));
	 }
}

package question.hundred.to.last;

public class MaxRectangle {
	public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0; 
        int max = 0; 
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j]=='1') {
                    int area = maximalRectangle(matrix, i, j); 
                    if (area>max) max = area; 
                }
            }
        }
        return max; 
    }
    
    public int maximalRectangle(char[][] a, int row, int col) {
        int widMax=Integer.MAX_VALUE, area=0; 
        for (int i=row; i<a.length && a[i][col]=='1'; i++) {
            int wid=0, j=col; 
            while(j<a[0].length && a[i][j]=='1') {j++;  wid++; }
            if (wid<widMax) widMax=wid; 
            if ((i-row+1) * widMax>area) area =(i-row+1) * widMax  ; 
        }
        return area; 
    }
    
    public static void main(String[] args) {
    	char[][] matrix = new char[][]{"0001010".toCharArray(),"0100000".toCharArray(),	"0101001".toCharArray(),
    			"0011001".toCharArray(),"1111110".toCharArray(),"1001011".toCharArray(),"0100101".toCharArray(),
    			"1101110".toCharArray()	,"1010101".toCharArray(),"1110000".toCharArray()}; 
    	MaxRectangle mr = new MaxRectangle(); 
    	System.out.println(mr.maximalRectangle(matrix));
    	System.exit(0);
    }
}

package question1_30.q10;

public class Search2DMatrix {
//	public boolean searchMatrix(int[][] matrix, int target) {
//        int row = searchRow(0, matrix.length, target, matrix); 
//        if (row>=matrix.length || target<matrix[row][0]) return false; 
//        if (target==matrix[row][0]) return true; 
//        int m = matrix[row].length/2; 
//        while(m<matrix[row].length && m>0) {
//            if (matrix[row][m]==target) return true;
//            int temp =m;
//            if (matrix[row][m]<target) m = (m+matrix[row].length)/2; 
//            else m/=2; 
//            if (m==temp) return false; 
//         }
//         return false; 
//    }
    
    private int searchRow(int start, int end, int target, int[][] a){
        if (start>=end) return start; 
        int m = (start+end)/2; 
        if (target<a[m][0]) return searchRow(start, m-1, target, a); 
        if (target==a[m][0]) return m; 
        else return searchRow(m+1, end, target, a)-1; 
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0) return false; 
        int m = matrix.length, n = matrix[0].length; 
        if (target<matrix[0][0] || target>matrix[m-1][n-1]) return false; 
        int mid = m/2; 
        while(true) {
            if (target>matrix[mid][0]) {
                if (mid>=mid-1 || target<matrix[mid+1][0]) break;
                mid = (mid+m)/2;
            } else if (target<matrix[mid][0]) {
                if (mid>=1 || target>mid-1) {
                    mid -=1; break; 
                }
                mid= mid/2;
            }
        }
        if (target==matrix[mid][0]) return true; 
        if (target<matrix[mid][0] || target>matrix[mid][n-1]) return false; 
        int nid = n/2; 
        while(true) {
           if (target>matrix[mid][nid]) {
               if (nid==n) return false; 
               nid=(nid+n)/2; 
           } else if(target==matrix[mid][nid]) return true; 
           else {
               if(nid==0) return false; 
               nid=nid/2; 
           }
        }
     }   
    
    public static void main(String[] args) {
    	System.out.println(new Search2DMatrix().searchMatrix(new int[][]{{1, 3, 5}}, 5));
    	System.exit(0);
    }
}

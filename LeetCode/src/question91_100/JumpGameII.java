package question91_100;

import java.util.*;

public class JumpGameII {
	public int jump(int[] A) {
        if (A==null || A.length<=1 || A[0]==0) return 0; 
        return findPath(0, A, 1); 
    }
    
    public int findPath(int index, int[] a, int prevPath) {
    	if (a[index]==0) return 0; 
        if (index + a[index] >= a.length-1) return prevPath; 
        int maxReach = index + a[index];
        int maxIndex = index; 
        //every jump we find the index which can jump to farest element
        for (int i=index+1; i<=a[index]+index; i++) {
           if ((a[i] + i)> maxReach) {
        	   maxReach = a[i] + i; 
        	   maxIndex = i; 
           }
        }
        return findPath(maxIndex, a, prevPath+1);
    }
    
    public static void main(String[] args) {
    	JumpGameII jg2 = new JumpGameII(); 
    	int res = jg2.jump(new int[]{3,1,2,0,4}); 
    	System.out.println(res);
    }
}

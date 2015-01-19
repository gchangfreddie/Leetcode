package RecursiveAndDP;

import java.util.Stack;

public class JumpGame {
	public boolean canJump(int[] A) {
	       if (A.length<=1) return true; 
	    //   int maxCover=0;
	    //   for (int i=1; i<A.length; i++) {
	    //       maxCover=Math.max(maxCover, A[i-1])-1; 
	    //       if (maxCover<0) return false; 
	    //   }
	    //   return true;
	        Stack<Integer> stack = new Stack<Integer>(); 
	        stack.push(A.length-1); 
	        boolean[] visited= new boolean[A.length]; 
	        while (!stack.isEmpty()){
	            int i = stack.pop();
	            visited[i]=true; 
	            if (i==0) return true; 
	            for (int j=0; j<i; j++){
	                if (!visited[j] && A[j]+j>=i) stack.push(j); 
	            }
	        }
	        return false; 
	    }
}

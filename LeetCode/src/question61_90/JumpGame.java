package question61_90;

import java.util.Stack;

public class JumpGame {
	public boolean canJump(int[] A) {
		boolean[] visited = new boolean[A.length]; 
		Stack<Integer> stack = new Stack<Integer>(); 
		stack.push(A.length-1); 
		while(!stack.isEmpty()){
			int i=stack.pop(); 
			if (i==0) return true; 
			visited[i]=true; 
			for (int j=0; j<i; j++) {
				if (A[j]+j>=i && !visited[j]) stack.push(j); 
			}
		}
		return false; 
	}	

	public boolean canJump1(int[] A) {
		// int[] jump = new int[A.length]; 
		// jump[0]=0; 
		// for (int i=1; i<A.length; i++) {
		//     jump[i]=Math.max(jump[i-1], A[i-1])-1; 
		//     if (jump[i]<0) return false; 
		// }
		// return true; 

		int maxCover = 0; 
		for (int i=1; i<A.length; i++) {
			maxCover = Math.max(maxCover, A[i-1])-1;
			if (maxCover<0) return false; 
		}
		return true;
	}

	public static void main(String[] args) {
		JumpGame jg = new JumpGame(); 
		int[] a = new int[]{2,0,1,1,5,6,7,4};
		System.out.println(jg.canJump(a));

	}
}

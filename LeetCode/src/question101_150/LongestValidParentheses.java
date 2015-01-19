package question101_150;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s==null || s.length()<=1) return 0;
		Stack<Integer> stack = new Stack<Integer>(); 
		int max = 0, start = 0;   
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)=='(') {
				stack.push(i); 
			} else {
				if (stack.isEmpty()) {  
					start = i+1; 
				} else {
					stack.pop(); 
					if (stack.isEmpty()) {
					    max = Math.max(max, i-start+1);
					} else {
					    max = Math.max(max, i-stack.peek()); 
					}
				}
			}
		}
		return max; 
	}
	
	public static void main(String[] args){
		LongestValidParentheses lp = new LongestValidParentheses();  
		System.out.println(lp.longestValidParentheses("()(()()"));
	}
}

package question101_150;

import java.util.*;

public class EvaluateReversePolishNotation {
	public static int evalRPn(String[] tokens) { // after each compute, push the res back
		Stack<Integer> stack = new Stack<Integer>(); 
		String op = "+-*/"; 
		for (int i=0; i<tokens.length; i++){
			String s = tokens[i]; 
			if (op.contains(s)) {
				int opt2 =stack.pop(); 
				int opt1= stack.pop();
				int index = op.indexOf(s); 
				switch (index) {
				case 0: stack.push(opt1+opt2); break ; 
				case 1: stack.push(opt1-opt2); break;
				case 2: stack.push(opt1*opt2); break;
				case 3: stack.push(opt1/opt2); break;
				}
			} else { 
				int opt = Integer.parseInt(s); 
				stack.push(opt); 
			}
		}
		return stack.pop();  
		
	}
	
//	["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	
	public static void main(String[] args){
		String[] tokens = new String[]{ "2", "1", "+", "3", "*"}; 
		System.out.println(evalRPn(tokens));
		tokens = new String[]{ "4", "13", "5", "/", "+"};
		System.out.println(evalRPn(tokens));
		tokens = new String[] {"18"}; 
		System.out.println(evalRPn(tokens));
		tokens = new String[] {"3", "11", "5", "+", "-"}; 
		System.out.println(evalRPn(tokens));
	}
} 

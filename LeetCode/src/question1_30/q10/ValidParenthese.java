package question1_30.q10;

import java.util.Stack;

public class ValidParenthese {
	public static boolean isValid(String s) {
        Stack<String> stack = new Stack<String>(); 
        for (int i=0; i<s.length(); i++){
            String ch = s.substring(i, i+1); 
            if (ch.equals("(") || ch.equals("{") || ch.equals("[")) {
                stack.push(ch); 
            } else {
                if (stack.isEmpty()) return false; 
                String chpop = stack.pop(); 
                if ((ch.equals(")") && chpop.equals("(")) || (ch.equals("}") && chpop.equals("{")) || (ch.equals("]") && chpop.equals("["))) continue;
                else return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true; 
    }
	
	public static void main(String[] args){
		System.out.println(isValid("([)]")); 
	}
}

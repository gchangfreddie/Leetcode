package question31_60;

import java.util.*;

public class ValidParentheses {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); 
        if (s==null || s.length()==0) return true; 
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i); 
            if (!match(c, stack)) return false; 
        }
        if (stack.size()==0 )return true; 
        return false; 
    }
    
    public boolean match(char c, Stack<Character> s) {
    	if (s.isEmpty()) {
    		s.push(c); return true; 
    	}
        char lastC = s.peek(); 
        if (c == '{' || c == '[' || c == '(') {
            s.push(c); 
            return true; 
        } else {
            switch (c) {
                case '}': 
                    if (lastC== '{') {
                        s.pop(); return true;
                    }
                    return false; 
                case ')': 
                     if (lastC== '(') {
                        s.pop(); return true;
                    }
                    return false; 
                case ']': 
                     if (lastC== '[') {
                        s.pop(); return true;
                    }
                    return false;     
                default: 
                    return false; 
    
            }
        }
        
    }
    
    public static void main(String[] args) {
    	ValidParentheses v = new ValidParentheses(); 
    	boolean b = v.isValid("[");
    	System.out.println(b);
    }
}

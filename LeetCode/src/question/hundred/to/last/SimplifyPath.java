package question.hundred.to.last;

import java.util.*;

public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>(); 
        String[] p = path.split("/"); 
        for (String str : p) {
            if (str.equals(".") || str.length()==0) continue; 
            if (str.equals("..") ) {
                if (!stack.isEmpty()) stack.pop(); 
            } else {
                stack.push(str); 
            }
        }
        String s = ""; 
        while(!stack.isEmpty()){
            s = "/"+stack.pop()+s ; 
        }
        return s.length()==0 ? "/" : s;
	}
	
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath(); 
		System.out.println(sp.simplifyPath("/...")); 
	}

}

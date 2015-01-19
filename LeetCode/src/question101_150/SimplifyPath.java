package question101_150;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
        if (path.length()==0) return path; 
        Stack<String> stack = new Stack<String>(); 
        String[] p = path.split("/"); 
        StringBuilder sb = new StringBuilder(); 
        for (String s : p) {
            if (s.equals(".")||s.length()==0) continue; 
            if (s.equals("..")){
            	if (!stack.isEmpty()) stack.pop(); 
            }
            else stack.push(s); 
        }
        if (stack.isEmpty()) return "/"; 
        while(!stack.isEmpty()){
            sb.insert(0, "/"+stack.pop()); 
        }
        return sb.toString(); 
    }
	
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath(); 
//		System.out.println(sp.simplifyPath("/home/"));
		System.out.println(sp.simplifyPath("/..."));
	}
}

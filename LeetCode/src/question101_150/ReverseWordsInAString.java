package question101_150;

import java.util.*;

public class ReverseWordsInAString {
//	public String reverseWords(String s) {
//        Stack<String> stack = new Stack<String>(); 
//        for (int i=0; i<s.length(); i++){
//            StringBuilder sb = new StringBuilder(); 
//            while(i<s.length() && s.charAt(i)!=' ') {
//               sb.append(s.charAt(i)); 
//               i++;
//            }
//            if (sb.length()>0) stack.push(sb.toString()); 
//        }
//        StringBuilder sb = new StringBuilder(); 
//        while(!stack.isEmpty()){
//            sb.append(stack.pop()+" "); 
//        }
//        return sb.toString().trim(); 
//    }
	
	public String reverseWords1(String s) {
		if (s.length()==0) return s; 
		String res = new String(); 
		int start=0; 
		for (int i=0; i<s.length(); i++){
			while(i<s.length() && s.charAt(i)==' ') {
				i++;
			}
			start=i;
			while (i<s.length()&&s.charAt(i)!=' '){
				i++; 
			}
			res = s.substring(start, i) + " " + res; 
		} 
		return res.trim();
	}
	
	public String reverseString(String s) {
//		if (s.length()<=1) return s; 
//		char[] c = s.toCharArray(); 
//		int i=0, j=c.length-1; 
//		while (i<j){
//			char temp = c[i]; 
//			c[i++]=c[j]; 
//			c[j--]=temp; 
//		}
//		return String.valueOf(c); 
		return new StringBuilder(s).reverse().toString(); 
	}
	
	public static void main(String[] args) {
		System.out.println(new ReverseWordsInAString().reverseString("I can get Cisco's offer!"));
	}
}

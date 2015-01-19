package question.hundred.to.last;

import java.util.*;

public class RegExpMatch {
	 public static boolean isMatch(String s, String p) {
		 if ((s==null && p==null) || (s.length()==0 && p.length()==0) ) return true;
		 if (p.length()==0) return false; 
		 int i=0, j=0; 
		 char sc = s.charAt(i); 
		 char pc = p.charAt(j); 
		 if (j<p.length()-1){
			 if (p.charAt(j+1)!='*') {
				 if (sc==pc || pc =='.') return isMatch(s.substring(1), p.substring(1)); 
				 else return false; 
			 } else {
				 if (sc==pc || pc=='.') return isMatch(s.substring(1), p.substring(0));
				 else return isMatch(s.substring(0), p.substring(2));
			 }
		 } else {
			 if ((sc==pc || pc=='.') && s.length()==p.length()) return true; 
			 else return false; 
		 }
	 }
	 
	 public static void main(String[] args){
//		 System.out.println(regMatch("aa","a"));  //false
//		 System.out.println(regMatch("aa","aa")) ; // true
//		 System.out.println(regMatch("aaa","aa")) ; //false
//		 System.out.println(regMatch("aa", "a*") ); //true
//		 System.out.println( regMatch("aa", ".*") ); //true
//		 System.out.println( regMatch("ab", ".*") ); //true
//		 System.out.println(regMatch("aab", "c*a*b")) ; //true
//		 System.out.println(regMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b")) ; //true
		 System.out.println(regMatch("aaa", "ab*a*c*a"));
	 }
	 
	 public static boolean regMatch(String s, String p){
		 // init list from start
		 char[] re = p.toCharArray(); 
		 HashSet<Integer> list = new HashSet<Integer>(); 
		 for (int i=0; i<re.length; ) {
			 list.add(i++); 
			 if (i<re.length && re[i]=='*') list.add(i++); 
			 else break;
		 }
		 for (int i=0; i<s.length(); i++) {
			 char c = s.charAt(i); 
			 HashSet<Integer> next = new HashSet<Integer>(); 
			 Iterator<Integer> it = list.iterator(); 
			 while(it.hasNext()) {
				 int index = it.next(); 
				 if (index==re.length) continue; 
				 if (re[index]==c || re[index]=='.')  next.add(index+1); 
			 }	
			 it = next.iterator(); 
			 list.clear();
			 while(it.hasNext()){
				 int index = it.next() ;
				 while(true) {
					 if (index<re.length && re[index]=='*')  {
						 list.add(index-1); 
						 list.add(index+1); 
					 }
					 list.add(index++); 
					 if(index<re.length && re[index]=='*') list.add(index++); 
					 else break; 
				 }
			 }
		 }
		 if (list.contains(re.length)) return true; 
		 else return false; 
	 }
}

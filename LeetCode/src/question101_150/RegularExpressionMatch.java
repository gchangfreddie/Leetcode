package question101_150;

public class RegularExpressionMatch {
	public static boolean isMatch(String s, String p) {
		if (p.length()==0) return s.length()==0; 
		if (p.length()==1 || p.charAt(1)!='*'){
			if (s.length()>0 &&(p.charAt(0)=='.' || p.charAt(0)==s.charAt(0)) )
					return isMatch(s.substring(1), p.substring(1)); 
			else return false; 
		} else {
			while(s.length()>0 &&(p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))){
				if (isMatch(s, p.substring(2))) return true; 
				else s=s.substring(1); 
			}
			return isMatch(s, p.substring(2)); 
		}
		 
	}
	
	public static void main(String[] args){
		String s="a"; 
		System.out.println("substring " + s.substring(1));
		System.out.println(isMatch("aa","a")); //false
		System.out.println(isMatch("aa","aa")); //true
		System.out.println(isMatch("aa", "aaa")); //false
		
		System.out.println(isMatch("aa", "a*"));//true; 
		System.out.println(isMatch("aa", ".*"));//true;
		System.out.println(isMatch("ab", ".*"));//true;
		System.out.println(isMatch("aab", "c*a*b"));//true;
		System.out.println(isMatch("aaa", "a*a"));//true;
	}
}

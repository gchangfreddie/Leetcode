package question101_150;

public class RegExpMatch {
	public static boolean isMatch(String s, String p) {
		if(p.length() == 0)
            return s.length() == 0;
		
		if (p.length()==1 || p.charAt(1)!='*') {
			if (s.length()>0 && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')) 
				return isMatch(s.substring(1), p.substring(1)); 
			return false; 
		} else {
			while(s.length()>0 && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')){
				if (isMatch(s, p.substring(2))) return true;
				else s = s.substring(1); 
			}
			return isMatch(s, p.substring(2)); 
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("ab",".*c")); //false
	}
}

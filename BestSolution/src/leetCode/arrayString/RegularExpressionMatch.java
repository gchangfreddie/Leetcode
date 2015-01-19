package leetCode.arrayString;

public class RegularExpressionMatch {
	public boolean isMatch(String s, String p) {
        if (p.length()==0) return s.length()==0; 
        if (p.length()==1 || p.charAt(1)!='*'){
            if (s.length()>0 && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))) 
                return isMatch(s.substring(1), p.substring(1));
            else return false;     
        } else {
            if (s.length()>0 && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))) {
                if (isMatch(s, p.substring(2))) return true;
                else return isMatch(s.substring(1), p); 
            } else {
                return isMatch(s, p.substring(2)); 
            }    
        }
    }
}

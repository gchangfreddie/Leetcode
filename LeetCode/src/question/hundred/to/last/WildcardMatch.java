package question.hundred.to.last;

public class WildcardMatch {
	public boolean isMatch(String s, String p) {
        if (p.length()==0) return s.length()==0; 
        int i=0, j=0, pre_s=0, pre_p=0; 
        boolean hasStar=false; 
        
        while(i<s.length()){
            if (j<p.length() && (p.charAt(j)==s.charAt(i) || p.charAt(j)=='?')) {
                i++; j++;
            } else if (j<p.length() && p.charAt(j)=='*') {
                hasStar = true; 
                while(j<p.length() && p.charAt(j) == '*') j++; 
                if (j==p.length()) return true; 
                else {
                    pre_s = i; 
                    pre_p = j; 
                }
            } else if (hasStar) {
                pre_s++; 
                i=pre_s; 
                j=pre_p; 
            } else return false; 
        }
        
        while(j<p.length()){
            if (p.charAt(j++)!='*') return false; 
        }
        return true; 
    }
}

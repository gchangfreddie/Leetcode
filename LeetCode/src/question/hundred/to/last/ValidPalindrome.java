package question.hundred.to.last;

public class ValidPalindrome {
	public boolean isPalindrome(String str) {
        if (str==null || str.length()==0) return true; 
        int s =0, e = str.length()-1;
        while (s<e) {
            while(s<str.length() && !isValid(str.charAt(s))) s++; 
            while(e>=0 && !isValid(str.charAt(e))) e--; 
            if (s==str.length() || e<0) return true; 
            char sc = lower(str.charAt(s)); 
            char ec = lower(str.charAt(e)); 
            if (sc!=ec) return false; 
            s++; e--; 
        }
        return true;
    }
    
    public boolean isValid(char c) {
        if (('a'<=c && c <='z') || ('A'<= c && c<='Z') || ('0'<=c && c<= '9') ) return true;
        return false; 
    }
    
    public char lower(char c) {
        return Character.toLowerCase(c); 
    }
}

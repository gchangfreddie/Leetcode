package Palindrome;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if (s.length()==0) return true; 
        s=s.toLowerCase(); 
        int i=0, j=s.length()-1;
        while(i<j){
            char a = s.charAt(i); 
            char b = s.charAt(j); 
            if (!valid(a)) {
                i++; continue; 
            }
            if (!valid(b)) {
                j--; continue; 
            }
            if (a!=b) return false; 
            i++; j--; 
        }
        return true; 
    }
	
    public boolean valid(char c){
        return  (c<='z'&& c>='a') || (c>='0'&& c<='9') ; 
    }
    
    public static void main(String[] args){
    	ValidPalindrome v = new ValidPalindrome(); 
    	v.isPalindrome("ab"); 
    }
}

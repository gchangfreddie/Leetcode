package question31_60;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
        int i=0, j=s.length()-1; 
        while(i<j) {
            char ch1 = s.charAt(i), ch2 = s.charAt(j); 
            if (!isValid(ch1)) {i++; continue;}
            if (!isValid(ch2)) {j--; continue;}
            ch1=Character.toLowerCase(ch1); 
            ch2=Character.toLowerCase(ch2); 
            if (ch1==ch2) {
                i++; j--; 
            } else {
                return false; 
            }
        }        
        return true; 
    } 
   
    public static boolean isValid(char c) {
        if (c<='z' && c>='a' || c<='Z' && c>='A' || c>='0' && c<='9') return true; 
        return false; 
    }
	
	public static void main(String[] args){
		System.out.println(isPalindrome("0k.;r0.k;"));
	}
}

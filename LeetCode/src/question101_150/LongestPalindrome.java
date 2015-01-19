package question101_150;

public class LongestPalindrome {
	public String longestPalindromeSlow(String s) {
        if (s==null || s.length()==0) return s; 
        int max = 0; 
        String res =s.substring(0,1); 
        for (int i=0; i<s.length()-1; i++) {
            char ci = s.charAt(i); 
            for (int j=s.length()-1; j>i; j--) {
                char cj = s.charAt(j); 
                if (j-i+1<=max) break;
                if (cj==ci) {
                    String sub = s.substring(i, j+1); 
                    if (isPalindrome(sub) && sub.length()>max){
                        res = sub; 
                        max=sub.length();
                    }
                }
            }
            if (max>=(s.length()-i)) 
            	return res; 
        }
        return res; 
    }
    
    public boolean isPalindrome(String s) {
        if (s==null || s.length()<=1) return true; 
        int i=0, j=s.length()-1; 
        while (i<j){
            char ci=s.charAt(i); 
            char cj=s.charAt(j); 
            if (ci!=cj) return false;
            i++; 
            j--; 
        }
        return true; 
    }
    
    public String longestPalindrome(String s) {
    	if (s==null || s.length()<=1) return s;
    	String res = s.substring(0, 1);
    	int max = 1; 
    	for (int i=0; i<s.length(); i++) {
    		String p = findPal(s, i, i);
    		String p1 = ""; 
    		if (i<s.length()-1 && s.charAt(i)==s.charAt(i+1)) 
    			p1 = findPal(s, i, i+1); 
    		else 
    			p1= ""; 
    		String temp = p.length()>p1.length() ? p :p1; 
    		if (temp.length()>max) {
    			max = temp.length(); 
    			res = temp; 
    		}
    	}
    	return res; 
    }
    
    public String findPal(String s, int s0, int s1) {
    	int i= s0-1, j=s1+1; 
    	while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
    		i--; j++;
    	}
    	return s.substring(i+1, j); 
    }
    
    public static void main(String[] args) {
    	LongestPalindrome lp = new LongestPalindrome(); 
    	System.out.println(lp.longestPalindrome("sabbacabbafsd")); 
    }
}

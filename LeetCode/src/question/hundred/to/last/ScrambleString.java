package question.hundred.to.last;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
        if (s1==null || s2==null || s1.equals(s2)) return true; 
        if (s1.length()==1 && !s1.equals(s2)) return false; 
        int value1 = 0; 
        int value2 = 0; 
        for (int i=0; i<s1.length(); i++) {
        	char c1 = s1.charAt(i); 
        	value1 +=c1-'a'; 
        	value2 +=s2.charAt(i)-'a'; 
        }
        if (value1!=value2) 
        	return false; 
        for (int i=1;i<s1.length(); i++) {
        	String s1left = s1.substring(0, i); 
        	String s1right = s1.substring(i); 
        	int m = s1.length() - i; 
        	String s2left = s2.substring(m); 
        	String s2right = s2.substring(0, m); 
        	if ((isScramble(s1left, s2left) && isScramble(s1right, s2right)) ||
        		(isScramble(s1left, s2.substring(0, i)) && isScramble(s1right, s2.substring(i)))) return true; 
        }
        return false; 
    }
    
    public static void main(String[] args) {
    	String s1 = "great"; 
    	String s2 = "rgeat";
    	String s3 = "rgtae"; 
    	String s4 = "etgar"; 
    	ScrambleString ss = new ScrambleString(); 
//    	System.out.println(ss.isScramble(s1, s2));
//    	System.out.println(ss.isScramble(s1, s3));
    	System.out.println(ss.isScramble(s1, s4));
//    	System.out.println(ss.isScramble(s1, s1));
    }
}

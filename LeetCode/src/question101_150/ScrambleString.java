package question101_150;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if (s1.length()!=s2.length()) return false;
		if (s1.length()==1) return s1.equals(s2); 
		if (s1=="") return s2==""; 
		if (s1.equals(s2)) return true; 
		int sum =0; 
		for (int i=0; i<s1.length(); i++) {
		    sum+=s1.charAt(i); 
		    sum-=s2.charAt(i); 
		}
		if (sum!=0) return false; 
		for (int i=1; i<s1.length(); i++) {
			String s1left = s1.substring(0, i); 
			String s1right = s1.substring(i); 
			String s2left = s2.substring(0, i); 
			String s2right = s2.substring(i); 
			String s2left1 = s2.substring(s1.length()-i); 
			String s2right1 = s2.substring(0, s1.length()-i); 
			if ((isScramble(s1right, s2right) && isScramble(s1left, s2left)) ||
				(isScramble(s1left, s2left1) && isScramble(s1right, s2right1)))
				return true; 
		}
		return false; 
	}
	
	public static void main (String [] args){
		ScrambleString scs = new ScrambleString(); 
//		System.out.println("".equals(""));
		System.out.println(scs.isScramble("great","rgtae"));
	}
}

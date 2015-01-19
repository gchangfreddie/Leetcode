package leetCode.arrayString;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		int res=0, i=s.length()-1; 
		while(i>=0){
			while(i>=0 && !isValid(s.charAt(i))) i--; 
			if (i>=0) {
				while(i>=0 && isValid(s.charAt(i))) {
					res++; i--;
				}
				if (i<0 || s.charAt(i)==' ') return res;
				res=0;
			}
		}
		return res;
	}
	private static boolean isValid(char c){
		return ((c>='a' && c<='z') || (c>='A' && c<='Z')); 
	}
	
	public static void main(String[] args){
		System.out.println(lengthOfLastWord(" "));
	}
}

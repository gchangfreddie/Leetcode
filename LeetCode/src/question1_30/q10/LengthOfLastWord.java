package question1_30.q10;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
        char[] c = s.toCharArray(); 
        int len=0, size = c.length; 
        for (int i=0; i<size; i++) {
        	if (c[i] == ' ') {
	            while (c[i]==' ') {
	                i++; 
	                if (i==size) return len;
	            }
	            len=1; 
        	} else {
        		len++;
        	}
        }
        return len; 
    }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World "));
	}
}

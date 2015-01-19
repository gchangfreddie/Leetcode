package question101_150;

public class Strstr {
	public static String strStr(String haystack, String needle) {
        if (haystack==null || needle ==null || needle.length()>haystack.length()) return null; 
        if (needle.length()==0) return haystack; 
        int j=0, start=0, i=start; 
        while(i<haystack.length()){ // Notice: must not use for loop since after each for i will ++, so it will mess up i value
            char c = needle.charAt(j); 
            if (c!=haystack.charAt(i)) {
                start++; 
                i=start; 
                j=0;
            } else {
                if (j==needle.length()-1) return haystack.substring(start); 
                j++;
                i++; 
            }    
                    
        }
        return null; 
    }
	
	public static void main(String[] args) {
		System.out.println(strStr("mississippi", "issi"));
	}
}

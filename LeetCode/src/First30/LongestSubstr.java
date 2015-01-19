package First30;

public class LongestSubstr {
	public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0; 
        if (s.length()==1) return 1; 
        int i=0, len=1, j; 
        for (j=1; j<s.length(); j++){
            String sub = s.substring(i, j); 
            if (sub.contains(String.valueOf(s.charAt(j)))){
                if ((j-i)>len) 
                	len = j-i;
                i = sub.indexOf(s.charAt(j))+i+1; 
            }
        }
        if (j-i>len) len = j-i; // this is necessary, please see below example string
        return len; 
    }
	
	public static void main(String[] args){
		LongestSubstr lss = new LongestSubstr(); 
		System.out.println(lss.lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));
	}
}

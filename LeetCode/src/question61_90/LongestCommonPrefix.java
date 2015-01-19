package question61_90;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) return ""; 
        StringBuffer sb = new StringBuffer(); 
        for (int i=0; i<strs[0].length(); i++) {
            char d = strs[0].charAt(i); 
            for (String s : strs) {
                if (i>=s.length() || s.charAt(i)!=d) return sb.toString();  
            }
            sb.append(d); 
        }
        return sb.toString(); 
    }
	
	public static void main(String[] args) {
		String[] strs = new String[]{"aa", "a"}; 
		System.out.println(longestCommonPrefix(strs)); 
	}
}

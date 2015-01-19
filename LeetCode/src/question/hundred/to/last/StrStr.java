package question.hundred.to.last;

public class StrStr {
	public static String strStr(String haystack, String needle) {
		if (haystack==null || (haystack.length()==0 && needle.length()>0)) return null; 
        if (needle.length()==0) return haystack;
        int start=0, i=0, j=0; 
        while (i<haystack.length()) {
            if (haystack.charAt(i)==needle.charAt(j)) {
                if (j==needle.length()-1) 
                	return haystack.substring(start); 
                j++; 
            }
            else { 
            	j=0; start++; i=start-1; 
            }
            i++; 
        }
        return null; 
    }
	
	public static String strStr1(String haystack, String needle) {
        if (haystack.length()==0) return needle.length()==0 ? "" : null; 
        if (needle.length()==0) return haystack; 
        int j=needle.length()-1, start=0; 
        while(start<haystack.length()-j){
            char c = haystack.charAt(start+j); 
            if (c==needle.charAt(j)) {
                j--; 
                if (j<0) return haystack.substring(start); 
            } else {
                if (needle.indexOf(c)<0) start+=j+1; 
                else start+=1; 
                j=needle.length()-1;
            }
        }
        return null; 
    }
	
	public static void main(String[] args) {
		String res = strStr1("mississippi", "issipi"); 
		System.out.println(res);
	}
}

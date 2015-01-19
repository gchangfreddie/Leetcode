package leetCode.arrayString;

public class Strstr {
	public String strStr(String haystack, String needle) {
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
}

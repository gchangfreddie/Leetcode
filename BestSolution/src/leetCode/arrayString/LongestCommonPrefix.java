package leetCode.arrayString;

import java.util.Arrays;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        Arrays.sort(strs); 
        int last = strs.length-1; 
        StringBuilder sb = new StringBuilder(); 
        for (int i=0; i<strs[0].length(); i++) {
            char c1 = strs[0].charAt(i); 
            if (i>strs[last].length()) return sb.toString(); 
            char c2 = strs[last].charAt(i); 
            if (c1!=c2) return sb.toString(); 
            sb.append(c1); 
        }
        return sb.toString(); 
    }
}

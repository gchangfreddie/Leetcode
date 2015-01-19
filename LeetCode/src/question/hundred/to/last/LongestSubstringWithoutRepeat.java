package question.hundred.to.last;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
	public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0; 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
        int max = 0, len=0, start = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i); 
            if (map.containsKey(c) && map.get(c) >=start) {
                if (len>max) max = len; 
                len = i - map.get(c); 
                start = map.get(c)+1; 
            } else {
                len++; 
            }       
            map.put(c, i); 
        }
        if (len>max) return len; 
        return max; 
    }
}

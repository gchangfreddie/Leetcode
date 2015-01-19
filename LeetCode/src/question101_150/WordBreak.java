package question101_150;

import java.util.*;

public class WordBreak {
	public static boolean wordBreak(String s, Set<String> dict) {
        if (s.length()==0 || dict.contains(s)) return true; 
        boolean[] match = new boolean[s.length()+1]; 
        match[0]=true; 
        for (int i=1; i<=s.length();i++){
            for (int k=i-1; k>=0; k--){
                if (match[k] && dict.contains(s.substring(k, i))) {
                    match[i]=true;
                    break;
                }    
            }
        }
        return match[s.length()]; 
    }
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>(); 
		dict.add("a"); 
		dict.add("abc");
		dict.add("b"); 
		dict.add("cd");
		
		System.out.println(wordBreak("abcd", dict));
	}
}

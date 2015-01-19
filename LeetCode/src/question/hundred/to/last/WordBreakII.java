package question.hundred.to.last;

import java.util.*;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>(); 
        boolean[] possible = new boolean[s.length()+1]; 
        for (int i=0; i<possible.length; i++) possible[i]=true; 
        wordBreak(s, 0, dict, "", res, possible); 
        return res;
    }
    
    public boolean wordBreak(String s, int start, Set<String> dict, String ss, List<String> res, boolean[] possible) {
        if (s.length()==start) {
            res.add(ss.trim()); 
            return true;
        } else{
            boolean temp=false;
            for (int i=start+1; i<=s.length(); i++){
                if (dict.contains(s.substring(start, i)) && possible[i]) {
                    if (wordBreak(s, i, dict, ss+s.substring(start, i)+" ", res, possible)){
                        temp = true;
                    }
                }
            }
            if (!temp) possible[start]=false;
            return possible[start]; 
        }
    }
    
    public static void main(String[] args) {
    	WordBreakII wb2 = new WordBreakII(); 
    	Set<String> dict = new HashSet<String>(); 
		dict.add("cat"); dict.add("sand"); dict.add("cats"); 
		dict.add("dog"); dict.add("and"); 
    	List<String> res = wb2.wordBreak("catsanddog", dict); 
    	for (String s : res) {
    		System.out.println(s);
    	}
    	
    }
}

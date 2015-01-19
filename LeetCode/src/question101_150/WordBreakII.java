package question101_150;

import java.util.*;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>(); 
        if (dict.isEmpty()) return res; 
        boolean[] possible = new boolean[s.length()+1]; 
        for (int i=0; i<=s.length(); i++) possible[i] = true; 
        wordBreak(0, s, dict, "", res, possible); 
        return res; 
    }
    
    public boolean wordBreak(int index, String str, Set<String> dict, String sentence, List<String> res, boolean[] possible) {
        //base case
        if (index == str.length()) {
            res.add(sentence); 
            return true; 
        } else {
        	possible[index] = false; 
            for (int i=index+1; i<=str.length(); i++){
                String substr = str.substring(index, i); 
                if (dict.contains(substr) && possible[i]) {
                	String temp = sentence.length() ==0 ? substr :  sentence + " " + substr; 
                    if (!wordBreak(i, str, dict, temp , res, possible)) {
                    	possible[i] = false; 
                    } else {
                    	possible[index] = true; 
                    }
                }
            }
        }
        return possible[index]; 
    }
    
    public static void main(String[] args){
    	WordBreakII wb2 = new WordBreakII(); 
    	Set<String> dict = new HashSet<String>(); 
    	dict.add("cats"); dict.add("dog"); dict.add("cat"); dict.add("and"); dict.add("sand");
    	dict.add("a"); dict.add("aa"); dict.add("aaa"); dict.add("aaaa"); dict.add("aaaaa");
    	dict.add("aaaaaa"); dict.add("aaaaaaa"); dict.add("aaaaaaaa"); dict.add("aaaaaaaaa"); dict.add("aaaaaaaaaa"); 
    	List<String> res = wb2.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", dict); 
    	for (String str : res) {
    		System.out.println(str);
    	}
    }
}

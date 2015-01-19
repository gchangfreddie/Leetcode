package leetCode.combination;

import java.util.*;

public class LetterCombOfPhoneNum {
	public List<String> letterCombinations(String digits) {
        String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
        List<String> res = new ArrayList<String>(); 
        com(digits, 0, res, "", phone); 
        return res;
    }
    
    public void com(String digits, int d, List<String> res, String prefix, String[] phone){
        if (digits.length()==d) res.add(prefix); 
        else {
            int c = digits.charAt(d)-'0'; 
            char[] array = phone[c].toCharArray(); 
            for (char ch : array){
                com(digits, d+1, res, prefix+ch, phone); 
            }
        }
    }
}

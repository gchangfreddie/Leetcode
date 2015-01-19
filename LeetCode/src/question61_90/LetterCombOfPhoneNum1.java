package question61_90;

import java.util.*;

public class LetterCombOfPhoneNum1 {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>(); 
		if (digits==null || digits.length()==0) {
			res.add(""); 
			return res; 
		}
		String[] value = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
		construct(res, value, digits, 0, ""); 
		return res; 
	}
	
	private void construct(List<String> res, String[] value, String digits, int d, String prefix){
		if (d==digits.length()) {
			res.add(prefix);
			return; 
		}
		int index = digits.charAt(d)-'0'-2; 
		String str = value[index]; 
		for (int j=0; j<str.length(); j++){
			construct(res, value, digits, d+1, prefix + String.valueOf(str.charAt(j))); 
		}
	}
	
	public static void print(List<String> a) {
		for (String s : a) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args){
		LetterCombOfPhoneNum1 lcop = new LetterCombOfPhoneNum1(); 
		List<String> res = lcop.letterCombinations("23"); 
		print(res); 
	}
}

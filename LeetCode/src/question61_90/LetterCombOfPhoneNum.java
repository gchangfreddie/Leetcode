package question61_90;

import java.util.*;

public class LetterCombOfPhoneNum {
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res= new ArrayList<String>(); 
		res.add(""); 
		HashMap<Integer, ArrayList<Character>> map = buildMap(); 
        if (digits==null || digits.length()==0) return res; 
        for (int i=0; i<digits.length();i++) {
        	char c = digits.charAt(i); 
        	ArrayList<String> tempRes = new ArrayList<String>(res); 
        	for (String s : tempRes) {
        		ArrayList<Character> set = map.get(c-'0'); 
        		for (char cs: set) {
	        		StringBuffer sb = new StringBuffer(s); 
	        		sb.append(cs); 
	        		res.add(sb.toString()); 
        		}
        		res.remove(s); 
        	}
        }
        return res; 
    }
	
	private HashMap<Integer, ArrayList<Character>> buildMap(){
		HashMap<Integer, ArrayList<Character>> res = new HashMap<Integer, ArrayList<Character>>(); 
		String[] s = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
		for (int i=2; i<=9; i++) {
			ArrayList<Character> al = new ArrayList<Character>(); 
			String ss = s[i-2]; 
			for (int j=0; j<ss.length(); j++) {
				al.add(ss.charAt(j)); 
			}
			res.put(i, al);
		}
		return res;
	}
	
	public static void print(ArrayList<String> a) {
		for (String s : a) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args){
		LetterCombOfPhoneNum lcop = new LetterCombOfPhoneNum(); 
		ArrayList<String> res = lcop.letterCombinations("23"); 
		print(res); 
	}
}

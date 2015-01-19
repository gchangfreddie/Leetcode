package question.seventy.to.hundred;

import java.util.*;

public class PalindromePatition {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>(); 
		if (s==null || s.length()==0) return res; 
		ArrayList<String> a = new ArrayList<String>(); 
		recursive(s, res, a);
		return res; 
	}

	public void recursive(String s, List<List<String>> list, ArrayList<String> alist) {
		if (s.length()==0) {list.add(alist); 
		} else {
			for (int i=1; i<s.length()+1; i++){
				String ss = s.substring(0, i);
				if (isPalindrome(ss)){
					ArrayList<String> temp = new ArrayList<String>(alist); 
					temp.add(ss); 
					recursive(s.substring(i,s.length()), list, temp); 
				}
			}
		}
	}

	private boolean isPalindrome(String s) {
		if (s==null || s.length()<=1) return true; 
		int len = s.length();
		for (int i=0; i<len/2; i++) {
			char ss = s.charAt(i); 
			char e = s.charAt(len-1-i); 
			if (ss!=e) return false;
		}
		return true;   
	}
	
	public static void main(String[] args) {
		PalindromePatition pp = new PalindromePatition(); 
		List<List<String>> a = pp.partition("bb");
		for (List<String> ll : a) {
			for (String s : ll) {
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}
}

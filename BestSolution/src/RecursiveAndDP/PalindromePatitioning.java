package RecursiveAndDP;
import java.util.*;
public class PalindromePatitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>(); 
		if (s.length()==0) return res;
		dfs(s, res, new ArrayList<String>(), 0); 
		return res;
	}

	public void dfs(String s, List<List<String>> res, List<String> list, int index){
		if (index==s.length()) res.add(new ArrayList<String>(list));
		else {
			for (int i=index+1; i<=s.length(); i++){
				if (isPalindrome(s.substring(index, i))){
					list.add(s.substring(index, i)); 
					dfs(s, res, list, i); 
					list.remove(list.size()-1); 
				}
			}
		}
	}

	private boolean isPalindrome(String s) {
		int i=0, j=s.length()-1; 
		while(i<j) {
			if (s.charAt(i++)!=s.charAt(j--)) return false;
		}
		return true; 
	}
}

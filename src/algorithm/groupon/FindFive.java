package algorithm.groupon;

import java.util.*;

public class FindFive {
	public List<Integer> findFive(int n) {
		List<Integer> res = new ArrayList<Integer>(); 
		if (n<5) return res; 
		int len = String.valueOf(n).length(); 
		foo(res, len, n, "", 0, false); 
		return res; 
	}
	
	public void foo(List<Integer> res, int len, int n, String prefix, int d, boolean haveFive){
		if (d==len){
			if (Integer.parseInt(prefix)<=n) 
				res.add(Integer.parseInt(prefix)); 
		} else {
			for (char c='0'; c<='9'; c++){
				if (d==len-1) {
					if (!haveFive && c!='5') continue; 
				}
				foo(res, len, n, prefix+c, d+1, haveFive|c=='5'); 
			}
		}
	}
	
	public static void main(String[] args){
		FindFive ff = new FindFive(); 
		List<Integer> res = ff.findFive(5556); 
		System.out.println(res.size());
	}
}

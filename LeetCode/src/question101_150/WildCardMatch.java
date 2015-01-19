package question101_150;

import java.util.*;

public class WildCardMatch {
	public boolean isMatch(String s, String p) {
		if (p.length()==0) return s.length()==0; 

		int i=0, j=0; 
		int pre_s=0, pre_p=0;
		boolean has_star = false; 
		while(i<s.length()) {
			if (j<p.length() && (p.charAt(j)== s.charAt(i) || p.charAt(j)=='?')) {
				i++; j++;
			} else if (j<p.length() && p.charAt(j)=='*'){
				has_star = true; 
				while (j<p.length() && p.charAt(j)=='*') 
					j++; 
				if (j==p.length()) return true; 
				pre_s=i; pre_p=j; 
			} else if (has_star) {
				pre_s++; 
				j=pre_p;  i=pre_s; 
			} else return false; 
		}
		while(j<p.length()) {
			if (p.charAt(j++)!='*') return false; 
		}
		return true; 
	}
	
//	public boolean isMatch(String s, String p) {
//		if (p.length()==0) return s.length()==0; 
//		StringBuilder sb = new StringBuilder(); 
//		for (int i=0; i<p.length(); ) {
//			if (p.charAt(i)!='*') sb.append(p.charAt(i++)); 
//			else {
//				while(i<p.length() && p.charAt(i)=='*') i++; 
//				sb.append('*');
//			}
//		}
//		p=sb.toString(); 
//		int i=0; 
//		HashSet<Integer> set = new HashSet<Integer>(); 
//		set.add(0); 
//		if (p.charAt(0)=='*') set.add(1); 
//		while(i<s.length()) {
//			Iterator<Integer> it = set.iterator(); 
//			HashSet<Integer> temp = new HashSet<Integer>(); 
//			while(it.hasNext()) {
//				int j=it.next(); 
//				if (j==p.length()) continue;
//				if (p.charAt(j)=='?' || p.charAt(j)==s.charAt(i)) temp.add(j+1); 
//				else if (p.charAt(j)=='*'){
//					temp.add(j); 
//					temp.add(j+1); 
//				}
//			}
//			it = temp.iterator(); 
//			set.clear();
//			while(it.hasNext()){
//				int index = it.next();
//				set.add(index); 
//				if (index==p.length()) continue; 
//				if (p.charAt(index)=='*') set.add(index+1); 
//			}
//			i++; 
//		}
//		if (set.contains(p.length())) return true;
//		else return false; 
//	}
	
	public static void main(String[] args) {
		WildCardMatch wcm = new WildCardMatch();
//		System.out.println(wcm.isMatch("ab", "*a"));
		System.out.println(wcm.isMatch("accbcbccx", "a*b*d"));
//		System.out.println(wcm.isMatch("b", "?*?"));
//		System.out.println(wcm.isMatch("aab", "c*a*b"));
//		System.out.println(wcm.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
//		System.out.println(wcm.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
//		System.out.println(wcm.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
	}
}

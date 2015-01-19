package question91_100;

import java.util.*;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> res = new ArrayList<String>(); 
        if (strs.length==0) return res; 
        HashMap<String, List<String>> map = new HashMap<String, List<String>>(); 
        for (String s : strs){
            char[] c = s.toCharArray(); 
            Arrays.sort(c); 
            String ss = String.valueOf(c); 
            if (!map.containsKey(ss)){
                List<String> l = new ArrayList<String> ();
                map.put(ss, l); 
            }
            map.get(ss).add(s); 
        }
        for (String s : map.keySet()) {
            if (map.get(s).size()>1) {
                res.addAll(map.get(s)); 
            }
        }
        return res; 
	}
	
	public static void main(String[] args) {
		Anagrams a = new Anagrams(); 
		List<String> res = a.anagrams(new String[]{"", "grace", "grace"});
		for (String s: res) {
			System.out.print(" " + s);
		}
	}
}

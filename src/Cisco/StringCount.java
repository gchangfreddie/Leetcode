package Cisco;

import java.util.HashMap;

public class StringCount {
	//gggaaabcbd
	// HashMap<Charactor, Integer> int is the count of the char
	// iterate the map to find the char which the value is 1
	// if (map.containsKe
	public static int foo(String s) {
		if (s==null || s.length()==0) return -1; 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i); 
			if (map.containsKey(c)) {
				int temp = map.get(c); 
				map.put(c, temp+1);
			}
			else map.put(c, 1); 
		}
		int index = s.length(); 
		for (Character c : map.keySet()) {
			if (map.get(c)==1) {
				if (s.indexOf(c)<index) index=s.indexOf(c); 
			}
		}
		return index;
	}
	
	public static void main(String[] args){
		System.out.println(foo("tgggaaabcbddkok"));
	}
}

package strings;

import java.util.*;

public class SubstrWithConcateAllWords {
	public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>(); 
        if (L.length==0 || S.length()==0) return res; 
        HashMap<String, Integer> map = new HashMap<String, Integer>() ; 
        HashMap<String, Integer> temp = new HashMap<String, Integer>(); 
        for (int i=0; i<L.length; i++) {
        	if (map.containsKey(L[i])) {
        		map.put(L[i], map.get(L[i])+1); 
        	} else {
        		map.put(L[i], 1); 
        		temp.put(L[i], 0); 
        	}
        }
        int count=0, start=0, w = L[0].length(); 
        for (int i=0; i<=S.length()-w; ) {
        	String str = S.substring(i, i+w); 
        	if (map.containsKey(str) && temp.get(str)<map.get(str)){
        		temp.put(str, temp.get(str)+1); 
        		count++; 
        		if (count==L.length) {
        			res.add(start); 
        			String s = S.substring(start, start+w); 
        			temp.put(s, temp.get(s)-1); 
        			start+=w; 
        			count--; 
        		}	
        		i+=w; 
        	} else {
        		if (!map.containsKey(str)){
        			i=start+1; 
        			start=i; 
        			count=0; 
        			for (String key : temp.keySet()) {
        				temp.put(key, 0); 
        			}
        		} else {
        			String substr = S.substring(start, i); 
        			int index = substr.indexOf(str)+start; 
        			start=index+w; 
        			i+=w; 
        		}
        	}
        }
        return res; 
    }
	
	public static void main(String[] args){
		String[] list = new String[] {"a", "b", "a"}; 
		List<Integer> res =findSubstring("abbaaa", list); 
		for (int i : res) {
			System.out.println(i);
		}
	}
}

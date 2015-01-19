package question101_150;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstrWithConcate {
	public List<Integer> findSubstring1(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>(); 
        int len = L[0].length(), i=0, count=0, start=0; 
        if (S.length()<len) return res;
        HashMap<String, Integer> map1 = new HashMap<String, Integer>(); 
        HashMap<String, Integer> map2 = new HashMap<String, Integer>(); 
        for (int j=0; j<L.length; j++){
            if (map1.containsKey(L[j])) {
                map1.put(L[j], map1.get(L[j])+1); 
            } else {
                map1.put(L[j], 1); 
                map2.put(L[j], 0); 
            }
        }
        while(i<=S.length()-len){
            String word = S.substring(i, i+len); 
            if (map1.containsKey(word)){
                if (count==0) start=i; 
                if (map2.get(word)<map1.get(word)) {
                    map2.put(word, map2.get(word)+1); 
                    count++; 
                    if (count==L.length) {
                        res.add(start); 
                        String w = S.substring(start, start+len); 
                        map2.put(w, map2.get(w)-1); 
                        count--; 
                        start+=len; 
                    }
                } else {
                    start+=len; 
                }
                i+=len; 
            } else {
                start++; 
                i=start;
                for (String key : map2.keySet()) map2.put(key, 0) ;
                count=0; 
            }
        }
        return res;
    }
	
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>(); 
        if (L==null || L.length == 0 || S==null || S.length()==0) return res;
        HashMap<String, Integer> list = new HashMap<String, Integer>(); 
        HashMap<String, Integer> tempSet = new HashMap<String, Integer>(); 
        for (int i=0; i<L.length; i++) {
        	if (list.containsKey(L[i])) {
        		list.put(L[i], list.get(L[i])+1); 
        	} else {
        		list.put(L[i], 1); 
        		tempSet.put(L[i], 0); 
        	}
        }
        int len = L[0].length(), start=0, count = 0; 
        for (int i=0; i<=S.length()-len; ) {
        	String curWord = S.substring(i, i+len); 
        	if (list.containsKey(curWord) && tempSet.get(curWord)< list.get(curWord)) {
        		tempSet.put(curWord, tempSet.get(curWord)+1);
        		count++; 
        		if (count==L.length)  {
        			res.add(start); 
        			tempSet.put(S.substring(start, start+len ), tempSet.get(S.substring(start, start+len ))-1);
        			count--; 
        			start+=len; 
        		}
        		i+=len; 
        	} else {
        		if (!list.containsKey(curWord)) { 
        			i=start+1; 
        			start = i; 
        			count=0; 
        			for (String key : tempSet.keySet()) {
        				tempSet.put(key, 0); 
        			}
        		} else {
        			String tempStr = S.substring(start); 
        			int index = tempStr.indexOf(curWord); 
        			int tempStart = start; 
        			start+=index+len; 
        			for (int k=tempStart; k<start; k+=len) {
        				String ss = S.substring(k, k+len); 
        				if (!ss.equals(curWord)) {
        					tempSet.put(ss, tempSet.get(ss)-1);
        					count--; 
        				}	
        			}
        			i+=len; 
        		}
        	}
        }
        return res;  
    }
	
	public static void main(String[] args){
		String[] list = new String[] {"a"}; 
		SubstrWithConcate swc = new SubstrWithConcate(); 
		List<Integer> res = swc.findSubstring1("a", list); 
		for (Integer i : res) {
			System.out.println(i);
		}
//		System.out.println(new String("BBBCBCCB").matches("(A|(B|C*)*)"));
		
//		String pattern = "(grace|google)"; 
//		String text = "gracegooglegooglegrace"; 
//		Pattern pat = Pattern.compile(pattern); 
//		Matcher matcher = pat.matcher(text); 
//		while(matcher.find()){
//			System.out.println(matcher.group());
//		}
	}
}

package leetCode.arrayString;
import java.util.*;
public class Anagrams {
	public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>(); 
        if (strs.length==0) return res; 
        HashMap<String, List<String>> map = new HashMap<String, List<String>>(); 
        for (String st : strs){
            char[] ch = st.toCharArray(); 
            Arrays.sort(ch); 
            String s =String.valueOf(ch); 
            if (!map.containsKey(s)){
                map.put(s, new ArrayList<String>()); 
            }
            map.get(s).add(st); 
        }
        for (String key : map.keySet()){
            if (map.get(key).size()>1) {
                res.addAll(map.get(key)); 
            }
        }
        return res;
    }
}

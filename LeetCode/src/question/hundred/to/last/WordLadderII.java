package question.hundred.to.last;

import java.util.*;

public class WordLadderII {
	public List<List<String>> findLadders1(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>> (); 
        if (start==null || end==null || dict.size()==0 ) return res; 
        dict.add(end); 
        HashMap<String, List<String>> preNode = new HashMap<String, List<String>>(); 
        for (String s: dict) preNode.put(s, new ArrayList<String>()); 
        preNode.put(start, new ArrayList<String>()); 
        LinkedList<String> queue = new LinkedList<String> (); 
        LinkedList<String> curLevel = new LinkedList<String>(); 
        queue.add(start); 
        while(!queue.isEmpty()){
            while(!queue.isEmpty()) {
                String s = queue.poll(); 
                dict.remove(s); 
                curLevel.add(s); 
            }
            for (String s : curLevel) {
                for (int i=0; i<start.length(); i++){
                    char[] charArray = s.toCharArray(); 
                    for (char c='a'; c<='z'; c++) {
                        charArray[i]=c;
                        String str = new String(charArray); 
                        if (!str.equals(s) && dict.contains(str) && !preNode.get(str).contains(s)){
                            if (!queue.contains(str)) queue.add(str); 
                            preNode.get(str).add(s); 
                        }
                    }
                }
            }
            if (queue.contains(end)) break;
            curLevel.clear(); 
        }
        LinkedList<String> temp = new LinkedList<String>(); 
        temp.add(end); 
        buildPath(start, temp, res, preNode); 
        return res; 
    }
	
    private void buildPath(String start, LinkedList<String> list, List<List<String>> res, HashMap<String, List<String>> map) {
        String str = list.get(0); 
        if (str.equals(start)) {
            List<String> temp = new LinkedList<String> (list); 
            res.add(temp); 
        } else {
           for (String s: map.get(str)){
               list.addFirst(s); 
               buildPath(start, list, res, map); 
               list.removeFirst(); 
           }
        }
    }    
	
    
	public static void main(String[] args){
		WordLadderII wl2 = new WordLadderII(); 
		HashSet<String> dict = new HashSet<String>(); 
		//"ted","tex","red","tax","tad","den","rex","pee"
		dict.add("ted"); dict.add("tex"); dict.add("red"); 
		dict.add("tax"); dict.add("tad"); dict.add("den"); 
		dict.add("rex"); dict.add("pee"); 
		List<List<String>> res = wl2.findLadders1("red", "tax", dict); 
		for (List<String> list : res) {
			System.out.println(list);
		}
	}
}

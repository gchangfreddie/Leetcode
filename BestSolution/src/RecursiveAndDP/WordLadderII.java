package RecursiveAndDP;

import java.util.*;

public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>(); // final result
        dict.remove(start); dict.add(end); 
        Queue<String> queue = new LinkedList<String>(); // level queue to hold all words in same level
        queue.add(start); 
        HashMap<String, List<String>> map= new HashMap<String, List<String>>(); 
        boolean finished = false; // flag to indicate whether we have found at least one shortest path
        HashSet<String> visited = new HashSet<String>();  // this set is to temporarilly record the words will be removed from dict
        while (!queue.isEmpty()) {
            Queue<String> tempQ = new LinkedList<String>(queue); 
            queue.clear(); 
            while(!tempQ.isEmpty()) {
                String word = tempQ.remove(); 
                for (int i=0; i<word.length(); i++){
                    char[] ch = word.toCharArray(); 
                    for (char c='a'; c<='z'; c++) {
                        ch[i]=c; 
                        String t = new String(ch); 
                        if (dict.contains(t)){
                            if (!map.containsKey(word)) map.put(word, new ArrayList<String>()); 
                            map.get(word).add(t); 
                            if (end.equals(t)) finished=true;
                            else if (!queue.contains(t)) queue.add(t); // we must check whether t is already in queue, otherwise TLE, t can be added by another word in previous level
                            visited.add(t); 
                        }
                    }
                }
            }
            if (finished) {
               build(map, start, end, res, new ArrayList<String>());  return res; 
            }
            dict.removeAll(visited); 
        }
        return res; 
    }
    
    public void build(HashMap<String, List<String>> map, String start, String end, List<List<String>> res, List<String> list){
    	list.add(start); 
        if (start.equals(end)){
            res.add(list); 
        } else if (map.containsKey(start)){
            for (String s : map.get(start)){
                List<String> temp = new ArrayList<String>(list); 
                build(map, s, end, res, temp); 
            }  
        }
    }
    
    public static void main(String[] args){
    	WordLadderII wl2 = new WordLadderII(); 
		HashSet<String> dict = new HashSet<String>(); 
		dict.add("a"); dict.add("b"); dict.add("c"); 
		//"ted","tex","red","tax","tad","den","rex","pee"
//		dict.add("ted"); dict.add("tex"); dict.add("red"); 
//		dict.add("tax"); dict.add("tad"); dict.add("den"); 
//		dict.add("rex"); dict.add("pee"); 
		List<List<String>> res = wl2.findLadders("a", "c", dict); 
		for (List<String> list : res) {
			System.out.println(list);
		}
    }
}

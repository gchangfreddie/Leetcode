package question.hundred.to.last;

import java.util.*;

public class WordLadder {
	public int ladderLength1(String start, String end, Set<String> dict) {
        LinkedList<String> queues = new LinkedList<String>(); 
        queues.add(start); 
        dict.add(end); 
        LinkedList<Integer> distance = new LinkedList<Integer>(); 
        distance.add(dict.contains(start) ? 0 : 1); 
        while(!queues.isEmpty()) {
            String cur = queues.removeFirst(); 
            int curDistance = distance.removeFirst(); 
            if (cur.equals(end)) return curDistance+1; 
            for (int i=0; i<cur.length(); i++) {
                char[] charArray = cur.toCharArray(); 
                for (char c='a'; c<='z'; c++) {
                    charArray[i]=c; 
                    String newStr = new String(charArray); 
                    if (dict.contains(newStr)){
                        dict.remove(newStr); 
                        queues.addLast(newStr); 
                        distance.addLast(curDistance+1); 
                    }
                }
            }
        }
        return 0; 
    }
	
	 public int ladderLength(String start, String end, Set<String> dict) {
	        HashSet<String> visited = new HashSet<String> (); 
	        Queue<String> q = new LinkedList<String>(); 
	        q.add(start); 
	        visited.add(start); 
	        int count=0; 
	        while(!q.isEmpty()){
	            count++; 
	            List<String> list = new ArrayList<String>(q); 
	            q.clear(); 
	            for (int j=0; j<list.size(); j++){
	                String cur = list.get(j); 
	                for (int i=0; i<cur.length(); i++){
	                	char[] array = cur.toCharArray(); 
	                    for (char c='a'; c<='z'; c++){
	                        array[i]=c;
	                        String ss = String.valueOf(array); 
	                        if (dict.contains(ss) && !visited.contains(ss)){
	                            if (end.equals(ss)) return count+1;
	                            visited.add(ss); 
	                            q.add(ss); 
	                        }
	                    }
	                }
	            }
	        }
	        return 0; 
	    }
	
	public static void main(String[] args) {
		WordLadder wl = new WordLadder(); 
		Set<String> dict = new HashSet<String>(); 
		dict.add("hot"); dict.add("dog"); dict.add("dot"); 
		System.out.println(wl.ladderLength("hot", "dog", dict));
		
		
	}
}

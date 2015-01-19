package dfsAndBfs;
import java.util.*; 
public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		dict.add(end); dict.remove(start); 
		Queue<String> q = new LinkedList<String>(); 
		q.add(start); 
		int count=1; 
		while(!q.isEmpty()){
			Queue<String> temp = new LinkedList<String>(q);
			q.clear(); 
			while(!temp.isEmpty()){
				String word = temp.remove(); 
				for (int i=0; i<word.length(); i++) {
					char[] ch = word.toCharArray(); 
					for (char c='a'; c<='z'; c++) {
						ch[i]=c; 
						String t = new String(ch); 
						if (dict.contains(t)) {
							if (t.equals(end)) return count+1;
							dict.remove(t); 
							q.add(t); 
						}    
					}
				}
			}
			count++; 
		}
		return 0;
	}
	public int ladderLength1(String start, String end, Set<String> dict) {
        if (start.equals(end)) return 1; 
        dict.add(end);  dict.remove(start); 
        Queue<String> list = new LinkedList<String>(); 
        list.add(start); 
        return ladderRecursive(end, dict, list, 1); 
    }
    
    public int ladderRecursive(String end, Set<String> dict, Queue<String> list, int level) {
        if (dict.size()==0 || list.size()==0) return 0; 
        Queue<String> queue = new LinkedList<String>(list); 
        list.clear(); 
        while (!queue.isEmpty()) {
            String start = queue.remove(); 
            for (int i=0; i<start.length(); i++){
                char[] charArray = start.toCharArray(); 
                for (char c='a'; c<='z'; c++){
                    charArray[i]=c; 
                    String temp = String.valueOf(charArray); 
                    if (dict.contains(temp)){
                        if (temp.equals(end)) return level+1; 
                        list.add(temp); 
                        dict.remove(temp); 
                    }
                }
            }
        }    
        return ladderRecursive(end, dict, list, level+1); 
    }
}   

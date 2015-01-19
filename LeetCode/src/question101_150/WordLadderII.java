package question101_150;
import java.util.*;

public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>(); 
		if (start == null || end==null || dict.size()==0) return res; 
		dict.add(end); 
		LinkedList<String> queue = new LinkedList<String>();
		LinkedList<String> currentlevel = new LinkedList<String>(); 
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); 
		for (String s: dict) {
			map.put(s, new ArrayList<String>());
		}
		map.put(start, new ArrayList<String>());
		map.put(end, new ArrayList<String>()); 
		queue.add(start); 
		
		while (!queue.isEmpty()) {// each loop is a new level
			while (!queue.isEmpty()) {
				String str = queue.poll();
				dict.remove(str); 
				currentlevel.add(str); 
			}
			
			for (String curStr : currentlevel) {
				for (int i=0; i<curStr.length(); i++) {
					for (char c='a'; c<='z'; c++) {
						char[] charArray = curStr.toCharArray(); 
						charArray[i] = c; 
						String newString = new String (charArray); 
						if (!newString.equals(curStr) && dict.contains(newString) && !map.get(newString).contains(curStr)) {
							map.get(newString).add(curStr); 
							if (!queue.contains(newString)) queue.add(newString); 
						}
					}
				}
			}
			
			if (queue.contains(end)) break; 
			currentlevel.clear(); 
		}
		LinkedList<String> temp = new LinkedList<String>(); 
		temp.addLast(end); 
		buildPath(start, end, map, temp, res); 
		return res; 
    }

	private void buildPath(String start, String end, HashMap<String, ArrayList<String>> visited, LinkedList<String> temp, List<List<String>> res) {
		String str = temp.get(0);
		
		//base case
		if (str.equals(start)) {
			LinkedList<String> list = new LinkedList<String>(temp); 
			res.add(list); 
			return ; 
		}
		//normal case
		for (String string: visited.get(str)) {
			temp.addFirst(string); 
			buildPath(start, end, visited,temp, res );
			temp.removeFirst(); 
		}
	}
	
	public static void main(String[] args) {
		WordLadderII wl2 = new WordLadderII(); 
		Set<String> dict = new HashSet<String>(); 
		dict.add("hot"); dict.add("dog");
		dict.add("dot"); dict.add("cog"); dict.add("pot");dict.add("hop");dict.add("hog");dict.add("tot");
		List<List<String>> res = wl2.findLadders1("hot", "dog", dict); 
		for (List<String> list : res) {
			System.out.println(list);
		}
	}
	
	public List<List<String>> findLadders1(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>(); 
        dict.add(end); 
        dict.remove(start); 
        HashMap<String, List<String>> path = new HashMap<String, List<String>>(); 
        Queue<String> queue = new LinkedList<String>(); 
        queue.add(start); 
        boolean temp=false;
        while(!queue.isEmpty() && !temp){
            LinkedList<String> layer = new LinkedList<String>(queue); 
            queue.clear(); 
            List<String> visited = new LinkedList<String>(); 
            for (int i=0;i<layer.size(); i++){
                String s = layer.get(i); 
                for (int j=0; j<s.length(); j++){
                    char[] c = s.toCharArray(); 
                    for (char ch='a'; ch<='z'; ch++) {
                        c[j]=ch; 
                        String ss = new String(c); 
                        if (dict.contains(ss)) {
                            visited.add(ss);  
                            if(!path.containsKey(ss)) {
                               path.put(ss, new ArrayList<String>()); 
                            } 
                            path.get(ss).add(s); 
                            if (ss.equals(end)){
                                temp=true;
                            } else {
                                queue.add(ss); 
                            }
                        }
                    }
                }    
            }
            dict.removeAll(visited); 
        }
        List<String> list = new LinkedList<String>(); 
        list.add(end); 
        buildPath(res, path, end, list, start); 
        return res; 
    }
    
    public void buildPath(List<List<String>> res, HashMap<String, List<String>> map, String end, List<String> list, String start){
        if (end.equals(start)){
            Collections.reverse(list);
            res.add(list); 
        } else {
            List<String> l = map.get(end); 
            for (int i=0; l!=null && i<l.size(); i++){
                List<String> temp = new LinkedList<String>(list); 
                temp.add(l.get(i)); 
                buildPath(res, map, l.get(i), temp, start); 
            }
        }
    }
}

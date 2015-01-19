package Cisco;
import java.util.*;
public class FindFriends {
	public boolean findFriends(List<String> list, String target){
		for (String s: list) {
			if (target.equals(s)) return true; 
		}
		LinkedList<String> q = new LinkedList<String>(); 
		Set<String> set = new HashSet<String>();
		while(!list.isEmpty()) {
			// copy list to q clear list
			q=new LinkedList<String>(list); 
			list.clear(); 
			while(!q.isEmpty()) {
				String e = q.remove();
				if (!set.contains(e)) {
					set.add(e); 
					// for all friends of e, check whether that is the target person, if yes, just return 
	//				otherwise put them in list, 
//					List<String> friend = e.getAllFriends(); 
//					for (String s : friend) {
//						if (target.equals(s)) return true;
//						list.add(s); 
//					}
				}
			}	
		}
		return false;
	}
}

package question101_150;

import java.util.*;

public class MinWindowSubString {
	public String minWindow(String S, String T) {
		HashMap<Character, Integer> needToFill = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
		int count = 0;
		for(int i = 0; i < T.length(); i++){
			if(!needToFill.containsKey(T.charAt(i))){
				needToFill.put(T.charAt(i), 1);
				hasFound.put(T.charAt(i), 0);
			}else {
				needToFill.put(T.charAt(i), needToFill.get(T.charAt(i)) + 1);
			}
		}
		
		int minWinBegin=-1; 
		int minWinEnd = S.length(); 
		for (int begin=0, end=0; end<S.length(); end++) {
			char c = S.charAt(end); 
			if (needToFill.containsKey(c)) {
				hasFound.put(c, hasFound.get(c)+1); 
				if (hasFound.get(c)<=needToFill.get(c)) {
					count++; 
				}
				if (count==T.length()) {
					while (!needToFill.containsKey(S.charAt(begin)) || hasFound.get(S.charAt(begin))>needToFill.get(S.charAt(begin))) {
						if (needToFill.containsKey(S.charAt(begin)) && hasFound.get(S.charAt(begin))>needToFill.get(S.charAt(begin)) ) {
							hasFound.put(S.charAt(begin), hasFound.get(S.charAt(begin))-1); 
						}
						begin++; 
					}
					if (end-begin<minWinEnd-minWinBegin) {
						minWinBegin = begin; 
						minWinEnd = end; 
					}
				}	
				
				}
			}
		return minWinBegin == -1 ? "" : S.substring(minWinBegin, minWinEnd+1); 
	}
	
	public static void main(String[] args) {
		MinWindowSubString mwss = new MinWindowSubString(); 
		System.out.println(minWindow1("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow1("acbbaca", "aba"));
		System.out.println(minWindow2("bba", "ab"));
	}
	
	public static String minWindow1(String S, String T) {
        String res = ""; 
        int m = T.length(), n= S.length(); 
        if (m==0 || n==0) return res;   
        int[] charNum = new int[256]; 
        for (int i=0; i<m; i++) {
            charNum[T.charAt(i)]++; 
        }
        int count = 0; 
        int min = n+1; 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        for (int i=0; i<n; i++) {
            char c = S.charAt(i); 
            if (T.contains(String.valueOf(c))) {
                queue.addLast(i); 
                if (charNum[c]>0) {
                    count++;
                    if (count==m) {
                        int head = queue.removeFirst(); 
                        if ((i-head+1)<min) {
                            min = i-head+1; 
                            res = S.substring(head, i+1); 
                        }
                        charNum[S.charAt(head)]++; 
                        count--; 
                    }
                }
                charNum[c]--; 
                while (!queue.isEmpty() && charNum[S.charAt(queue.getFirst())]<0) {
                	int index = queue.removeFirst();
                	charNum[S.charAt(index)]++; 
                }
            }
        }
        return res; 
    }
	
	public static String minWindow2(String S, String T) {
        int m=S.length(), n=T.length(); 
        if (m<n ) return ""; 
        int i=0, count=0, min=m+1; 
        String res="";
        LinkedList<Integer> indexList = new LinkedList<Integer>(); 
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>(); 
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>(); 
        for (int j=0; j<n; j++){
            char c = T.charAt(j);
            if (map1.containsKey(c)) map1.put(c, map1.get(c)+1);
            else {
                map1.put(c, 1); 
                map2.put(c, 0); 
            }
        }
        while(i<m){
            char c = S.charAt(i); 
            if (map2.containsKey(c)) {
                indexList.add(i); 
                if (map2.get(c)<map1.get(c)){
                    count++; 
                }
                map2.put(c, map2.get(c)+1); 
                while (count==n) {
                	int start = indexList.removeFirst();
                    int len = i-start+1; 
                    if (len<min) {
                        min=len;
                        res=S.substring(start, i+1); 
                    }
                    map2.put(S.charAt(start), map2.get(S.charAt(start))-1);
                    if (map2.get(S.charAt(start))<map1.get(S.charAt(start))) 
                    	count--; 
                }
            }
            i++; 
        }
        return res;
    }
}

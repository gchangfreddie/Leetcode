package question101_150;

import java.util.*;

public class TestJustification {
	public List<String> fullJustify(String[] words, int L) {
		List<String> res = new ArrayList<String>(); 
		if (words==null || words.length==0) return res; 
		if (L==0) {
			res.add(""); 
			return res; 
		}
		int i=0; 
		while(i<words.length) {
			int count=0; 
			List<String> tempRes = new ArrayList<String>(); 
			StringBuilder sb = new StringBuilder(); 
			while(i<words.length && (words[i].length()+count) <= L) {
				count +=words[i].length();
				tempRes.add(words[i]); 
				count++; 
				i++; 
			}
			count--; 
			//adjust 
			int numOfSpace = tempRes.size()==1? 1: tempRes.size()-1; 
			int extraSpace = L-count; 
			int space = numOfSpace <=0 ? 0 : extraSpace/numOfSpace; 
			int num = numOfSpace<=0 ? 0: extraSpace%numOfSpace; 
			for (int index=0; index<tempRes.size(); index++) {
				sb.append(tempRes.get(index)); 
				if (index!=tempRes.size()-1) sb.append(" ");
				if (i==words.length) {
					if (index!=tempRes.size()-1) continue; 
					else {
						int len = L-sb.length(); 
						for (int k =0; k<len; k++) sb.append(" "); 
						break; 
					}
				}
				for (int j = 0; (index!=tempRes.size()-1||tempRes.size()==1 || i==words.length) &&j<space; j++) 
					sb.append(" ");
				if (index<num) sb.append(" "); 
			}
			res.add(sb.toString()); 
		}
		return res; 
	}

	public List<String> fullJustify1(String[] words, int L) {
        List<String> res = new ArrayList<String>(); 
        if (words.length==0) return res; 
        int i=0, count=0; 
        List<String> tempRes = new ArrayList<String>(); 
        while(i<words.length) {
            while(i<words.length && (count+words[i].length()) <= L) {
                count+=words[i].length()+1;
                tempRes.add(words[i]); 
                i++; 
            }
            count--; 
            int extraSpace = L-count;
            int slot = tempRes.size()==1 ? 1 : tempRes.size()-1; 
            int n = i==words.length ? 0 :extraSpace/slot; 
            int m = i==words.length ? 0 :extraSpace%slot;
            StringBuilder sb = new StringBuilder(); 
            for (int ii=0; ii<tempRes.size(); ii++){
                sb.append(tempRes.get(ii));
                if (ii<tempRes.size()-1) sb.append(" "); // this is necessary for "a", 1
                if (ii<tempRes.size()-1 || tempRes.size()==1) {
                    for (int j=0; j<n; j++) sb.append(" "); 
                    if (ii<m) sb.append(" "); 
                }
                if (i==words.length) {
                	if (ii==tempRes.size()-1) {
                		int len = L-sb.length(); 
						for (int k =0; k<len; k++) sb.append(" "); 
						break; 
                	}
                }
            }
            res.add(sb.toString()); 
            tempRes.clear(); 
            count=0; 
        }
        return res; 
    }
	public static void main(String[] args){
		TestJustification tj = new TestJustification(); 
//				String[] list = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//		String[] list = new String[]{"What","must","be","shall","be."}; 
//		String[] list = new String[]{"Listen","to","many,","speak","to","a","few."}; 
		String[] list = new String[]{"a"}; 
		List<String> res = tj.fullJustify1(list, 1); 
		for (String str : res) {
			System.out.println(str);
		}

	}
}

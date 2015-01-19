package question1_30.q10;

import java.util.*;

public class GenerateParenthese {
	public List<String> generateParenthesis(int n) {
		HashSet<String> set = new HashSet<String>(); 
		put(set,n, ""); 
		List<String> res = new ArrayList<String>(set); 
		return res;
	}

	public void put(HashSet<String> set, int n, String s){
		if (n==0) {
			set.add(s); 
		} else{
			for (int i=0; i<=s.length();i++){
				StringBuilder sb = new StringBuilder(s); 
				sb.insert(i, "()");
				put(set, n-1, sb.toString()); 
			}
		}
	}
	
	public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<String>(); 
        put(n, res, "", 0, 0); 
        return res;
    }
    
    public void put(int n, List<String> list, String s, int leftNum, int rightNum){
        if (leftNum+rightNum==2*n) {
            String ss = new String(s); 
            list.add(ss); 
            return; 
        }
        if (leftNum<n) {
            put(n, list, s+"(", leftNum+1, rightNum); 
        }
        if (rightNum<leftNum){
            put(n, list, s+")", leftNum, rightNum+1);
        }
    }

	public static void  main(String[] args){
		GenerateParenthese gp = new GenerateParenthese(); 
		List<String> a = gp.generateParenthesis1(3); 
		for (String b: a) {
			System.out.println(b);
		}
		System.exit(0);
	}
}

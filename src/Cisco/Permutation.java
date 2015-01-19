package Cisco;
import java.util.*;

public class Permutation {
	public List<String> permutation(String s){
		List<String>  res = new ArrayList<String>(); 
		if (s==null || s.length()==0) return res;
		boolean[] visited= new boolean[s.length()]; 
		permu(s, 0, res, "", visited); 
		return res;
	}
	
	private void permu(String s, int d, List<String> res, String ss, boolean[] visited){
		if (d==s.length()) res.add(ss); 
		else{
			char[] ch=s.toCharArray(); 
			for (int i=0; i<ch.length; i++){
				if (!visited[i]){
					visited[i]=true;
					permu(s, d+1, res, ss+ch[i], visited); 
					visited[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Permutation p = new Permutation(); 
		List<String> res = p.permutation("gra"); 
		for (String ss: res) {
			System.out.print(ss+" ");
		}
		System.exit(0);
	}
}

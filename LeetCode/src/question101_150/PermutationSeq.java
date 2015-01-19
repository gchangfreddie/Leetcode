package question101_150;

import java.util.*;

public class PermutationSeq {
//	public String getPermutation1(int n, int k) {
//		if (n==0) return null;
//		int[] num = new int[n];
//		for (int i=0; i<n; i++) {
//			num[i]=i+1; 
//		}
//		
//        StringBuffer sb = new StringBuffer(); 
//        k--; // shift from 1st to nth to 0th to (n-1)th 
//        for (int i=1; i<=n; i++) { // each time insert one
//        	int temp = k/factorial(n-i); 
//        	int number = num[temp];
//        	for (int j=temp; j<n-i; j++) {
//        		num[j]=num[j+1]; 
//        	}
//
//    		sb.append(number+""); 
//    		k=k%factorial(n-i); 
//        }
//        return sb.toString(); 
//    }
	 public String getPermutation1(int n, int k) {
	        int[] num = new int[n]; 
	        for (int i=0; i<n; i++) num[i]=i+1; 
	        k--; 
	        StringBuilder sb = new StringBuilder(); 
	        for (int i=1; i<=n; i++) {
	           int b = k/factorial(n-i); 
	           sb.append(num[b]); 
	           for (int j=b; j<n-i; j++){
	               num[j]=num[j+1]; 
	           }
	           k=k%factorial(n-i); 
	        }
	        return sb.toString();
	    }
	    
	    public int factorial(int n) {
	        if (n==0 || n==1) return 1; 
	        return n*factorial(n-1); 
	    }
	
//	private int factorial(int n) {
//		if (n==0 || n==1) return 1; 
//		return n*factorial(n-1); 
//	}
	
	public String getPermutation(int n, int k) {
        HashMap<Integer, String> map = new HashMap<Integer, String>(); 
        boolean[] marked = new boolean[n]; 
        dfs(map, marked, "", 0); 
        return map.get(k-1); 
    }
    
    public int dfs(HashMap<Integer, String> map, boolean[] marked, String b, int index) {
        if (b.length()==marked.length) {
            map.put(index, b); 
            return index+1; 
        } else {
            for (int i=1; i<=marked.length; i++) {
                if (!marked[i-1]){
                    marked[i-1]=true; 
                    index = dfs(map, marked, b+i, index);
                    marked[i-1]=false; 
                }
            }
            return index; 
        }
    }
	
	public static void main(String[] args) {
		PermutationSeq ps = new PermutationSeq(); 
		System.out.println(ps.getPermutation1(2, 1)); 
		System.out.println(ps.getPermutation(4, 17));
		System.out.println(ps.getPermutation1(4, 17));
	}
	
}

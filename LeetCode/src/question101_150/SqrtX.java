package question101_150;

public class SqrtX {
	public static int sqrt(int x) {
		if (x==0 || x==1) return x; 
		long root=x/2;
		long low = 1;
		while (low<=root) {	
			long m = (low+root)/2;
			if (m*m==x) return (int)m; 
			if (m*m<x) low = m+1; 
			else root=m-1; 
		}
		return (int)root; 
	}
	
	
	public static void main(String[] args){
		System.out.println(Integer.MAX_VALUE);
//		System.out.println(sqrt(2));
		System.out.println(sqrt(6));
//		System.out.println(sqrt(2147395599));
	}
}

package leetCode.bitManipulation;

public class SqrtX {
	public int sqrt(int x) {
		if (x==0 || x==1) return x;
		long low=1, root=x/2; //must use long, otherwise when m*m > x, overflow
		while(low<=root) { //must <= no <, when low <=root and m*m>x, root should be m-1;
			long m=(low+root)/2;
			if (m*m==x) return (int)m; 
			if (m*m>x) root=m-1;
			else low=m+1;
		}
		return (int)root; 
	}
}

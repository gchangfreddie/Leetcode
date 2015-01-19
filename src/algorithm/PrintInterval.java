package algorithm;

public class PrintInterval {
	public void printInterval1(int[] a) {
		if (a.length==0) System.out.println("0-99");
		int prev = -1; 
		for (int i=0; i<a.length; i++) {
			if (a[i]-1==prev) {
				prev=a[i]; 
			} else {
				if (prev+1==a[i]-1)
					System.out.println(prev+1);
				else
					System.out.println((prev+1) + "-" + (a[i]-1));
				prev=a[i];  
			}
			if (i==a.length-1 && a[i]!=99) 
				if (a[i]==98) System.out.println(99);
				else System.out.println((a[i]+1)+"-"+99);
		}
	}

	public static void main(String[] args){
		int [] t = new int[]{1}; 
		PrintInterval p = new PrintInterval(); 
		p.printInterval1(t);
	}
}

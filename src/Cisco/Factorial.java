package Cisco;

public class Factorial {
	public int facorial(int n) throws NumberFormatException{
		if (n<0) throw new NumberFormatException(); 
		if (n==0) return 1; 
		int temp = 1, i=1;
		while (i<=n) {
			temp*=i; 
			i++ ; 
		}
		return temp; 
	}
	
	public static void main(String[] args){
		Factorial f = new Factorial(); 
		System.out.print(f.facorial(10));
	}
}

package Cisco;

public class Fibonacci {
	public int fibonacci(int n) {
		if (n<0) return 0; 
		int[] dp = new int[2]; 
		dp[0]=0; 
		dp[1]=1; 
		if (n<=1) return dp[n]; 
		int i=3; 
		while (i<=n) {
			int temp = dp[0]+dp[1]; 
			dp[0]=dp[1]; 
			dp[1]=temp; 
			i++; 
		}
		return dp[1]; //O(n)
	}
	
	public int recursive(int n) {
		if (n==1) return 1; 
		if (n==0) return 0; 
		return recursive(n-1)+recursive(n-2);  // slow O(2^n)
	}
	
	public static void main(String[] args){
		Fibonacci f = new Fibonacci(); 
		int n=15, i=0; 
		int[] dp=new int[n+1]; 
		dp[0]=0; dp[1]=1;
		while(i<n){
			System.out.print(dp[i]+ " ");
			if (i<=n-2) dp[i+2]=dp[i]+dp[i+1]; 
			i++;
		}
		System.out.println();
		System.out.println(f.fibonacci(12)); 
//		System.out.println(f.recursive(151)); 
	}
}

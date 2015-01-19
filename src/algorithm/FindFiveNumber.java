package algorithm;

public class FindFiveNumber {
	public int find5(int n) {
		if (n<=0) return 0; 
		String s = String.valueOf(n); 
		// recursive append digit 
		return build(n, s.length(), "", 0, false); 
	}
	
	public int build(int n, int len, String s, int index, boolean haveFive) {
		if (index==len) {
			if (Integer.parseInt(s)<=n && haveFive) {
				return 1; 
			}	
			else {
				return 0; 
			}
		}	
		int result = 0; 
		for (int i=0; i<=9; i++) {
			if (index==len-1 && i!=5 && !haveFive) continue;
			result+=build(n, len, s+ String.valueOf(i), index+1, haveFive||i==5); 
		}
		return result; 
	}
	
	public int findFive(int n) {
		if (n<=0) return 0; 
		int bit = String.valueOf(n).length(); 
		int[] dp = new int[bit+1]; 
		// create a int[] to compute for 10, 100, 1000 .. how many 5 contains
		dp[0]=0;
		for (int i=1; i<dp.length; i++) {
			dp[i]=dp[i-1]*9+ (int)Math.pow(10, i-1); 
		}
		String s = String.valueOf(n); 
		int len = s.length()-1; 
		int res =0, i=len; 
		while (n!=0 && i>=0) {
			int t=(int)Math.pow(10, i); 
			int d= n/t;
			if (d<5) {
				res += d*dp[i]; 
			} else if (d==5) {
				res +=5*dp[i]+(n-d*t)+1; 
				break;
			} else {
				res +=(d-1)*dp[i]+(int)Math.pow(10,i);
			}
			i--; 
			n-=d*t; 
		}
		return res; 
	}
	
	public static void main(String[] args) {
		FindFiveNumber ffn = new FindFiveNumber(); 
//		int[] a = new int[]{1583};
//		int[] a = new int []{-1, 0, 1, 5, 9, 10, 12, 15, 49, 50, 51,59, 60, 99, 100, 549, 600,999, 1000, 55555, 504500}; 
//		for (int x : a) {
//			System.out.println(x + " " + ffn.findFive(x));
//			System.out.println(x + " " + ffn.find5(x));
//		}
		System.out.println(ffn.findFive(9556));
	}
}

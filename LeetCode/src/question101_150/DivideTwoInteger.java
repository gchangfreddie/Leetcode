package question101_150;

public class DivideTwoInteger {
	public int divide(int dividend, int divisor) {
		if (dividend==0 || divisor==0) return 0; 
		boolean neg = (dividend^divisor)<0 ? true : false; 
		int res = 0; 
		if (dividend==Integer.MIN_VALUE) {
			dividend+=Math.abs(divisor); 
			res+=1; 
		}
		if (divisor==Integer.MIN_VALUE) {
			return res; 
		}
		dividend=Math.abs(dividend); 
		divisor=Math.abs(divisor); 
		int digit=0; 
		while (divisor<=(dividend>>1)) { // while divisor< (dividend/2)
			digit++; 
			divisor<<=1; 
		}
		while(digit>=0) {
			if (dividend>=divisor) {
				dividend-=divisor; 
				res+=1<<digit;
			}
			digit--; 
			divisor>>=1; 
		}
		return neg? -res : res; 
	    }

public static void main(String[] args) {
	System.out.println(new DivideTwoInteger().divide(5, 2));
	//		System.out.println(divide(-119, -3)); 
	System.out.println(-119/-3);
}
}

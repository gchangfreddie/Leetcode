package question1_30.q10;

public class Divide2Integer {
	public static int divide(int dividend, int divisor) {
		if (dividend==0 || divisor == 0) return 0; 
		boolean neg = (dividend^divisor)>=0 ? false : true; 
		int res = 0; 
		if (dividend==Integer.MIN_VALUE){
			dividend+=Math.abs(divisor); 
			res+=1;
		}
		if (divisor==Integer.MIN_VALUE) return res;
		int digit=0;
		divisor=Math.abs(divisor); 
		dividend=Math.abs(dividend); 
		while(divisor<=(dividend>>1)){
			digit++; 
			divisor<<=1;
		}
		while(digit>=0) {
			if (divisor<=dividend){
				res+=1<<digit; 
				dividend-=divisor;
			}
			digit--; 
			divisor>>=1;
		}
		return neg ? -res : res;
	}

	public static void main(String[] args){
		System.out.println(divide(-2147483648, 1));
		System.out.println(divide(1, 1));
	}
}

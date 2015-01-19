package question.hundred.to.last;

public class DivTwoInt {
	public int divide(int dividend, int divisor) {
		if (dividend==0||divisor==0) return 0; 
        boolean isNeg = false; 
        if ((dividend^divisor)>>31 == 1) isNeg=true; 
        divisor=Math.abs(divisor); 
        dividend=Math.abs(dividend); 
        if (divisor==1) return isNeg ? -dividend:dividend; 
        int digit=0; 
        while(divisor<=(dividend>>1)){
            digit++;
            divisor<<=1; 
        }
        int res=0; 
        while(digit>=0) {
            if (dividend>=divisor){
                dividend-=divisor; 
                res+=1<<digit; 
            }
            digit--; 
            divisor>>=1; 
        }
        return isNeg? -res: res; 
	}

	public static void main(String[] args) {
		DivTwoInt dti = new DivTwoInt(); 
		System.out.println(Integer.MIN_VALUE/4);
//		System.out.println(dti.divide(1038925803, -2147483640)); 
		System.exit(0);
	}
}

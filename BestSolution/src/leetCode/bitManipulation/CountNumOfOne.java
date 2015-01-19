package leetCode.bitManipulation;

public class CountNumOfOne {
	public static int count(int number) {
		int count = 0; 
		number = Math.abs(number); 
		while(number!=0){
			int t= number&1; 
			if (t==1) count++; 
			number>>=1;
		}
		return count; 
	}
	
	public static void main(String[] args){
		int res = count(115); 
		System.out.println(res);
	}
}

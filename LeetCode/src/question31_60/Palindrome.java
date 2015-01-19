package question31_60;

public class Palindrome {
	public static boolean isPalindrome1(int x) {
		if (x<0) return false; 
		int temp =1; 
		while (x/temp>=10) {
			temp*=10; 
		}
		while(x!=0 ) {
			int first = x/temp; 
			int last = x%10; 
			if (first!=last) 
				return false; 
			x=(x-first*temp)/10; 
			temp/=100; 
		}
		return true; 
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome1(1021));
	}
}

package leetCode.bitManipulation;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if (x<0) return false; 
		int d = 1; 
		while (x/d>=10) 
			d*=10; 
		while (x!=0){
			int m=x%10; 
			int n=x/d;
			if (m!=n) return false; 
			x=(x-n*d)/10; 
			d/=100; 
		}
		return true; 
    }
}

package algorithm;

public class ReverseInteger {

	public int reverse(int x) {
        int j=0, i=x; 
        while(i!=0) {
        	j =j*10+i%10; 
        	i /= 10;
        }
        return j;
    }
	
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger(); 
		System.out.println(r.reverse(-2000001));
	}
}

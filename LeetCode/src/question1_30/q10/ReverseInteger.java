package question1_30.q10;

public class ReverseInteger {

	public static int reverse(int x) throws Exception{
		int res = 0; 
        while(x!=0){
            res = res*10 + x%10; 
            x/=10; 
        }
        return res; 
	    }
	
	public static void main(String[] args) {
		try {
			System.out.println(reverse(1000000003));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

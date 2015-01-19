package question61_90;

public class PowXN {
	 public static double pow(double x, int n) {
	        if (n==0) return 1.;
	        if (n<0) {
	            x=1./x; 
	            n=-n; 
	        }
	        // double temp = pow(x, n/2); 
	        // if (n%2==0) {
	        //     return temp*temp; 
	        // } else {
	        //     return temp*temp*x; 
	        // }
	        double res=1; 
	        while (n>0) {
	            if (n%2==1) res*=x; 
	            x*=x; 
	            n/=2; 
	        }
	        return res; 
	    }
	
	public static void main(String[] args) {
		double res = pow(8.88023, 3); 
		System.out.println(res);
		System.exit(0);
	}
}

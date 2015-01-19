package RecursiveAndDP;

public class Powxn {
	public double pow(double x, int n) {
        if (n==0) return 1.;
        if (n<0) {
            x=1./x; 
            n=-n; 
        }
        // double temp = pow(x, n/2); 
        // return n%2==0 ? temp*temp : temp*temp*x; 
        double res=1; 
        while (n>0) {
            if (n%2==1) res*=x; 
            x*=x; 
            n/=2; 
        }
        return res; 
    }
}

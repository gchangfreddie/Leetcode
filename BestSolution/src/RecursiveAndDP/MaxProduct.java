package RecursiveAndDP;

public class MaxProduct {
	public int maxProduct(int[] A) {
		if (A.length==0) return 0; 
        int max=A[0], min=A[0], res=A[0]; 
        for (int i=1; i<A.length; i++) {
            int temp=max;
            max=Math.max(A[i], Math.max(max*A[i], min*A[i])); 
            if (max>res) res=max;
            min=Math.min(A[i], Math.min(temp*A[i], min*A[i])); 
        }
        return res;
    }
	
	public static void main(String[] args){
		int[] a = new int[]{2, -8}; 
		MaxProduct mp = new MaxProduct(); 
		int res = mp.maxProduct(a); 
		System.out.println((int)Math.pow(10, 3));
		System.out.println(res);
	}
}

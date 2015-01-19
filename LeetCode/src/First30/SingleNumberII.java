package First30;

public class SingleNumberII {
	public int singleNumber(int[] A) {
		if (A==null && A.length==0) return 0; 
		int res =0; 
		for (int i=0; i<32; i++) {
			int bit=0; 
			for (int j=0; j<A.length; j++) {
				bit += (A[j]>>i)&1; // must &1 to clear all other bits
			}
			bit=bit%3;
			res |= bit<<i; 
		}
		return res; 
	}
	
	// don't understand
	int sol2(int A[], int n)
	{
	    int one = 0, two = 0, three = 0;
	    for (int i = 0;i < n;++i) {
	        two |= one & A[i];
	        one ^= A[i];
	        three = one & two;
	        one &= ~three;
	        two &= ~three;
	    }
	    return one;
	}
}

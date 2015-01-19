package First30;

public class UniqueBST {
	public int numTrees(int n) {
        int[] count = new int[n+1]; 
        if (n==0 || n == 1) return 1; 
        count[0] = 1; 
        count[1] = 1; 
        
        for (int i=2; i<=n; i++) {
            for (int j=0; j<i; j++) {
                count[i] += count[j] * count[i-1-j]; 
            }
        }
        return count[n]; 
    }
	
	public static void main(String[] args) {
		System.out.println(new UniqueBST().numTrees(2));
		
	}
}

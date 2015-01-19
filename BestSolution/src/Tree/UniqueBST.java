package Tree;

public class UniqueBST {
	public int numTrees(int n) {
		if (n==0 || n==1) return n; 
		int[] count = new int[n+1]; 
		count[0]=1; 
		count[1]=1;
		for (int i=2; i<=n; i++){
			for (int j=0; j<i; j++) {
				count[i]+=count[i-j-1]*count[j]; 
			}    
		}
		return count[n]; 
	}
	
	public int numTreesRecursive(int n) {
        if (n==0) return 0; 
        return numTrees(1, n); 
    }
    public int numTrees(int s, int e) {
        if (s>e) return 1; 
        int res=0; 
        for (int i=s; i<=e; i++) {
            res+=numTrees(s, i-1)*numTrees(i+1, e); 
        }
        return res;
    }
}

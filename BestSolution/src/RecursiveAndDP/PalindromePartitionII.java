package RecursiveAndDP;

public class PalindromePartitionII {
	public int minCut(String s) {
        int n=s.length();
        if (n<=1) return 0;
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++) {
            dp[i]=n-1-i; 
        }
        boolean[][] p = new boolean[n][n]; 
        for (int i=n-1; i>=0; i--){
            for (int j=i; j<n; j++){
                if (s.charAt(i)==s.charAt(j) && (j-i<2 || p[i+1][j-1])){
                    p[i][j]=true;
                    dp[i]=Math.min(dp[i],1+dp[j+1]); 
                }
            }
        }
        return dp[0]; 
    }
}

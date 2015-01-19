package question101_150;

public class PalindromePartitionII {
	public int minCut(String s) {
        if (s.length()==0 || isPalindrome(s)) return 0;  
        int min = s.length()-1; 
        for (int i=1; i<s.length(); i++){
            int left = minCut(s.substring(0, i)); 
            int right = minCut(s.substring(i)); 
            min = Math.min(min, left+right+1); 
        }
        return min; 
    }
	
	public boolean isPalindrome(String s) {
		if (s==null || s.length()==0) return true; 
		int i=0, j=s.length()-1; 
		while (i<j) {
			if (s.charAt(i)!=s.charAt(j)) return false; 
			i++; j--; 
		}
		return true; 
	}
	
	public int minCutDP(String s) {
		int len = s.length(); 
		if (len<=1) return 0; 
		boolean[][] p = new boolean[len][len]; 
		int[] d = new int[len+1]; 
		for (int i=0; i<len+1; i++) {
			d[i] = len-i-1; 
		}
		for (int i=0; i<len; i++) {
			for (int j=0; j<len; j++){
				p[i][j]=false; 
			}
		}
		for (int i=len-1; i>=0; i--) {
			for (int j=i; j<len; j++) {
				if (s.charAt(i)==s.charAt(j) && (j-i<2 || p[i+1][j-1] )) {
					p[i][j]=true; 
					d[i] = Math.min(d[i], 1+d[j+1]); 
				}
			}
		}
		return d[0]; 
	}
	
	public int minCut1(String s) {
        if (s.length()<=1) return 0; 
        int[][] dp = new int[s.length()][s.length()]; 
        for (int i=0; i<s.length(); i++){
            for (int j=i; j<s.length(); j++){
                dp[i][j]=j-i;
            }
        }
        for (int i=s.length()-1; i>=0; i--) {
            for (int j=i; j<s.length(); j++){
                if (i==j) dp[i][j]=0; 
                else if (i+1==j) dp[i][j]= s.charAt(i)==s.charAt(j) ? 0 : 1;
                else {  
                    if (s.charAt(i)==s.charAt(j)) dp[i][j]=dp[i+1][j-1]; 
                    else dp[i][j]=Math.min(dp[i+1][j], dp[i][j-1])+1;
                }    
            }
        }
        return dp[0][s.length()-1]; 
    }
	
	public static void main(String[] args) {
		PalindromePartitionII pp2 = new PalindromePartitionII(); 
		System.out.println(pp2.minCut1("ababbbabbaba"));
//		System.out.println(pp2.minCut1("aaabaa"));
	}
}

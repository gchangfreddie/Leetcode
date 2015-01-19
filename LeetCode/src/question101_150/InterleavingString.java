package question101_150;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length(), len2=s2.length(), len3=s3.length(); 
        if (len3!=len1+len2) return false; 
        boolean[][] match=new boolean[len1+1][len2+1]; 
        match[0][0]=true; 
        for (int i=0; i<=len1;i++) {
            for (int j=0; j<=len2; j++) {
                if (i==0 && j==0) continue; 
                char c = s3.charAt(i+j-1); 
                boolean m1 = (i!=0) ? (match[i-1][j] && s1.charAt(i-1)==c):false; 
                boolean m2 = (j!=0) ? (match[i][j-1] && s2.charAt(j-1)==c):false; 
                match[i][j]=m1||m2;
            }
        }
        return match[len1][len2]; 
    }
	
	public boolean isInterleaveMyVersion(String s1, String s2, String s3) {
        int m=s1.length(), n=s2.length(), p=s3.length(); 
        if (p!=m+n) return false; 
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0]=true; 
        for (int i=1; i<=m; i++) {
            if (s1.charAt(i-1)==s3.charAt(i-1)) dp[i][0]=true;
            else break; 
        }
        for (int j=1; j<=n; j++) {
            if (s2.charAt(j-1)==s3.charAt(j-1)) dp[0][j]=true; 
            else break;
        }
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j]= (dp[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1)) || (dp[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1)); 
            }
        }
        return dp[m][n];
    }
	
	public static void main(String[] args) {
		InterleavingString is = new InterleavingString();
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac", s4 = "aadbbbaccc"; 
		System.out.println(is.isInterleave(s1, s2, s4));
		System.out.println(is.isInterleave(s1, s2, s3));
	}
}

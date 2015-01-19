package question91_100;

public class DistinctSubsequences {
//	public int numDistinct(String S, String T) {
//		if (T==null || T.length()==0) return 1; 
//        if (S==null || S.length()==0) return 0; 
//        int res = 0; 
//        for (int i=0; i<S.length()-T.length()+1; i++){
//            if (S.charAt(i)==T.charAt(0)) {
//                res +=numDistinct(S.substring(i+1), T.substring(1)); 
//            }
//        }
//        return res; 
//    }
	
	public static void main(String[] args) {
		int num = new DistinctSubsequences().numDistinct("ccc", "c");
		System.out.println(num);
	}
	
	public int numDistinct1(String S, String T) {  
		  // Start typing your Java solution below  
		  // DO NOT write main() function  
		  int[][] dp = new int[T.length() + 1][S.length() + 1];  
		  dp[0][0] = 1;  
		  for (int i = 1; i <= T.length(); i++) {  
		    dp[i][0] = 0;  
		  }  
		  for (int j = 1; j <= S.length(); j++) {  
		    dp[0][j] = 1;  
		  }  
		  for (int i = 1; i <= T.length(); i++) {  
		    for (int j = 1; j <= S.length(); j++) {  
		      dp[i][j] = dp[i][j - 1];  
		      if (T.charAt(i - 1) == S.charAt(j - 1)) {  
		        dp[i][j] += dp[i - 1][j - 1];  
		      }  
		    }  
		  }  
		  return dp[T.length()][S.length()];  
		      
		}
	
	public int numDistinct(String s, String t) {
        int slen = s.length(); 
        int tlen = t.length(); 
        int[][] dp = new int[tlen+1][slen+1]; 
        dp[0][0] = 1; 
        for (int i=1; i<=slen; i++) {
            dp[0][i]=1; 
        }
        for (int i=1; i<=tlen; i++) {
            dp[i][0]=0; 
        }
        for (int i=1; i<=tlen; i++) 
            for (int j=1; j<=slen; j++) {
                dp[i][j] = dp[i][j-1]; 
                if(s.charAt(j-1)==t.charAt(i-1)) 
                    dp[i][j]+=dp[i-1][j-1]; 
            }
        return dp[tlen][slen];     
    }
}

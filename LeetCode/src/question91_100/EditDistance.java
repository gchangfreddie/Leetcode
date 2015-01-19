package question91_100;

public class EditDistance {
	public static int minDistance(String word1, String word2) {
		if (word1.length()==0) return word2.length() ; 
        if (word2.length()==0) return word1.length(); 
        if (word1.equals(word2)) return 0; 
//        int[][] dp = new int[word1.length()+1][word2.length()+1]; 
//        for (int i=0; i<=word1.length(); i++){
//            dp[i][0]=i;
//        }
//        for (int j=0; j<=word2.length(); j++){
//            dp[0][j]=j; 
//        }
//        for (int i=0; i<word1.length(); i++){
//            for (int j=0; j<word2.length();j++){
//                if (word1.charAt(i)==word2.charAt(j)) dp[i+1][j+1]=dp[i][j]; 
//                else {
//                    dp[i+1][j+1]=Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j])+1;
//                }
//            }
//        }
//		return dp[word1.length()][word2.length()];
		 int res = Integer.MAX_VALUE;  
		 int min = minDistance(word1.substring(1), word2.substring(1)); 
		 if (word1.charAt(0)==word2.charAt(0)) {
			     if (min<res) res = min; 
		 } else {
		     min = Math.min(min, Math.min(minDistance(word1.substring(1), word2), minDistance(word1, word2.substring(1)))); 
		     if (min+1<res) res = min+1;
		 }
		 return res;    
	}

public static void main(String[] args) {
	System.out.println(minDistance("grace", "gbae")); 
}
}

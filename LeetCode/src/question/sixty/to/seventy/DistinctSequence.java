package question.sixty.to.seventy;

public class DistinctSequence {
	public int numDistinct(String S, String T) {
		if (T.length()==0) return 1; 
        if (S.length()==0 || S.length()<T.length()) return 0; 
        int t = T.length(), s = S.length(); 
        int[] match = new int[t+1]; 
        match[0]=1; 
        for (int i=1; i<=s; i++) 
            for (int j=t; j>0; j--) {
                if (S.charAt(i-1)==T.charAt(j-1)) match[j]+=match[j-1]; 
            }
        return match[t];     
        /* int[][] match = new int[t+1][s+1]; 
         match[0][0]=1; 
         for (int i=1; i<=t; i++) match[i][0]=0; 
         for (int i=1; i<=s; i++) match[0][i]=1;
         for (int i=1; i<=t; i++) {
             for (int j=1; j<=s; j++) {
                 match[i][j]=match[i][j-1]; 
                 if (S.charAt(j-1)==T.charAt(i-1)) match[i][j]+=match[i-1][j-1]; 
             }
         }
         return match[t][s]; */ 
        // big data TLE
        /* if (T.length()==0) return 1; 
        // if (S.length()==0) return 0; 
        // int cnt=0; 
        // for (int i=0; i<S.length(); i++){
        //     if (S.charAt(i)==T.charAt(0)){
        //       cnt+= numDistinct(S.substring(i+1), T.substring(1)); 
        //     }
        // }
        return cnt; */
    }
	
	public static void main(String[] args) {
		DistinctSequence ds = new DistinctSequence(); 
		int res = ds.numDistinct("ddd", "dd"); 
		System.out.println(res);
	}
}

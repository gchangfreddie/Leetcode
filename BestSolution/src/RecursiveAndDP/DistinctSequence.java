package RecursiveAndDP;

public class DistinctSequence {
	public static int numDistinct(String S, String T) {
		int s=S.length(), t=T.length(); 
        int[][] match = new int[s+1][t+1]; 
        for (int i=0; i<=s; i++) match[i][0]=1;
        for (int i=1; i<=s; i++) {
            for (int j=1; j<=t; j++) {
                match[i][j]=match[i-1][j]; //base case is [0][j]
                if (S.charAt(i-1)==T.charAt(j-1)) match[i][j]+=match[i-1][j-1]; //base case is [i][0] & [0][j]
            }
        }
        return match[s][t]; 
    }
	
	public static void main(String[] args){
		int res = numDistinct("ccc", "c"); 
		System.out.println(res);
	}
}

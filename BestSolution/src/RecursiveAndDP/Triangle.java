package RecursiveAndDP;

import java.util.Arrays;
import java.util.List;

public class Triangle {
	// this is bottom up, it is better than top down
	public int minimumTotalButtomUp(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()==0) return 0; 
        int len=triangle.size(); 
        int[] dp=new int[len]; 
        for (int i=0; i<len; i++) dp[i]=triangle.get(len-1).get(i);  
        for (int i=len-2; i>=0; i--){
            List<Integer> temp = triangle.get(i); 
            for (int j=0; j<=i; j++){
                dp[j]=Math.min(dp[j], dp[j+1])+temp.get(j); 
            }
        }
        return dp[0]; 
    }
	
	// this is top down, it is better than top down
	public int minimumTotalTopDown(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()==0) return 0; 
        int len=triangle.size(); 
        int[] dp=new int[len]; 
        dp[0]=triangle.get(0).get(0); 
        for (int i=1; i<len; i++){
            List<Integer> temp = triangle.get(i); 
            dp[i]=dp[i-1]+temp.get(i);
            for (int j=i-1; j>0; j--){
                dp[j]=Math.min(dp[j], dp[j-1])+temp.get(j); 
            }
            dp[0]+=temp.get(0); 
        }
        Arrays.sort(dp); 
        return dp[0]; 
    }
}

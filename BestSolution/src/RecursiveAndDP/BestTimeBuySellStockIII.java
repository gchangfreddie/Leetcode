package RecursiveAndDP;

public class BestTimeBuySellStockIII {
	public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=1) return 0;
        
        int len=prices.length; 
        int[] left=new int[len]; 
        left[0]=0;
        int min=prices[0]; 
		for (int i=1; i<len; i++) {
			if (prices[i]<min) min=prices[i]; 
			left[i]=Math.max(prices[i]-min, left[i-1]); 
		}
		
		int[] right=new int[len]; 
		right[len-1]=0; 
		int max= prices[len-1];
		for (int i=len-2; i>=0; i--){
		    if (prices[i]>max) max=prices[i]; 
		    right[i]=Math.max(max-prices[i], right[i+1]); 
		}
		
		max=0;
		for (int i=0; i<len; i++) {
		    int temp = left[i]+right[i]; 
		    if (temp>max) max=temp; 
		}
		
		return max; 
	}
}

package question.hundred.to.last;

import java.util.PriorityQueue;

public class BestTimeBuySellStock {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length<=1 ) return 0; 
        int[] dp = new int[prices.length]; 
        buildLeft(prices, dp);
//        dp[0]=0;
        int[] dpp = new int[prices.length]; 
        buildRight(prices, dpp); 
        int max=0; 
        for (int i=0; i<prices.length; i++) {
        	max = Math.max(max, dp[i]+dpp[i]); 
        }
//        dpp[0] = maxProfit(prices, 0, prices.length-1); 
//        int max = dpp[0]; 
//        for (int i=1; i<prices.length; i++) {
//            if (i>1 && prices[i-1]>prices[i-2]) dp[i]=maxProfit(prices, 0, i-1); 
//            else dp[i]=dp[i-1]; 
//            if (prices[i]>prices[i-1]) dpp[i]=maxProfit(prices, i, prices.length-1); 
//            else dpp[i]=dpp[i-1]; 
//            int temp = dp[i] + dpp[i]; 
//            if (temp>max) 
//            	max = temp;
//        }
        return max; 
    }
	
	public void buildLeft(int[] a, int[] left) {
		left[0]=0; 
		int min=a[0]; 
		for (int i=1; i<a.length; i++) {
			min = Math.min(min, a[i]); 
			left[i] = Math.max(left[i-1], a[i]-min); 
		}
	}
	
	public void buildRight(int[] a, int[] right) {
		right[a.length-1] = 0;
		int max=a[a.length-1]; 
		for (int i=a.length-2; i>=0;i--) {
			max = Math.max(max, a[i]); 
			right[i] = Math.max(right[i+1], max-a[i]); 
		}
		
	}
    
    public int maxProfit(int[] a, int s, int e) {
        if (s>=e) return 0; 
        int min = Integer.MAX_VALUE, max = 0; 
        for (int i=s; i<=e; i++) {
            if (a[i]<min) min = a[i]; 
            if (a[i]-min>max) max = a[i]-min;
        }
        return max; 
    }
    
    public int maxProfit1(int[] prices) {
        if (prices.length<=1) return 0; 
        int len = prices.length;
        int min=prices[0], max=prices[len-1]; 
        int[] left = new int[len], right = new int[len]; 
        left[0]=0; right[len-1]=0;
        for (int i=1; i<len; i++) {
            left[i]=Math.max(left[i-1], prices[i]-min);
            min=Math.min(min, prices[i]);
        }
        for (int i=len-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], max-prices[i]); 
            max = Math.max(prices[i], max); 
        }
        int res = 0; 
        for (int i=0; i<len; i++) {
            if (left[i]+right[i]>res) res = left[i]+right[i]; 
        }
        return res;
    }
    
    public static void main(String[] args) {
//    	int[] stock = new int[]{6,1,5,3,7,4,9}; 
    	int[] stock = new int[]{2,1,4}; 
    	System.out.println(new BestTimeBuySellStock().maxProfit1(stock));
    }
}

package question31_60;

public class BestBuySellStockII {
	public int maxProfit(int[] prices) {
        if (prices==null || prices.length==0 ) return 0; 
        int maxProfit =0, minPrice=prices[0];  
        for (int i=0; i<prices.length; i++) {
            if ((prices[i]-minPrice)>maxProfit) {
                maxProfit = prices[i]-minPrice; 
            } else if (prices[i] < minPrice) {
                minPrice = prices[i]; 
            }
        }
        return maxProfit; 
    }
	
	public static void main(String[] args) {
		BestBuySellStockII bb = new BestBuySellStockII(); 
		System.out.println(bb.maxProfit(new int[]{4,9,2,8,3,6}));
	}
}

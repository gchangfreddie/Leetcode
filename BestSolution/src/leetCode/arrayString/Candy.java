package leetCode.arrayString;

public class Candy {
	public int candy(int[] ratings) {
        int[] candy = new int[ratings.length]; 
        for (int i=1; i<ratings.length; i++) {
            if (ratings[i]>ratings[i-1]) candy[i]=candy[i-1]+1;  
        }
        int res = candy[ratings.length-1]; 
        for (int i=ratings.length-2; i>=0; i--) {
            if (ratings[i]>ratings[i+1]) 
            	candy[i]=Math.max(candy[i+1]+1, candy[i]); // please notic should be Math.max(candy[i+1]+1, candy[i])
            res+=candy[i]; 
        }
        return res+ratings.length; 
    }
}

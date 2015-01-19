package question.hundred.to.last;

public class Candys {
	public int candy(int[] ratings) {
        int res = 0; 
        if (ratings==null || ratings.length==0) return res; 
    	int len = ratings.length; 
    	int[] c = new int[len]; 
    	for (int i=1; i<len; i++){
    	    if (ratings[i]>ratings[i-1]) c[i]=c[i-1]+1; 
    	}
    	for (int i=len-2; i>=0; i--) {
    	    if (ratings[i]>ratings[i+1]) c[i]=Math.max(c[i],c[i+1]+1); 
    	}
    	res = len; 
    	for (int i=0; i<len; i++) {
    	    res+=c[i]; 
    	}
    	return res; 
    }
    
    public static void main(String[] args) {
    	Candys c = new Candys(); 
    	int[] ratings = new int[]{4,2,3,4,1}; 
    	System.out.println(c.candy(ratings));
    }
}

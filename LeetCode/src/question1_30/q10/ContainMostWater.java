package question1_30.q10;

public class ContainMostWater {
	public int maxArea(int[] height) {
        if (height==null || height.length<=1) return 0;
        int max=0, maxHeight=0; 
        for (int i=0; i<height.length-1; i++) {
            if (height[i]<=maxHeight) continue;  
            maxHeight = height[i]; 
            for (int j=height.length-1; j>i; j--) {
                int area = area(i, j, height); 
                if (area >max) max=area;
                if (height[j]>=height[i])  break; 
            }
        }
        return max; 
    }
    
    public int area(int x, int y, int[] height) {
        int h = Math.min(height[x], height[y]); 
        int w = y-x; 
        return h*w;
    }
    
    public static void main(String[] args) {
    	ContainMostWater cm = new ContainMostWater(); 
    	int[] height = new int[]{5,2,12,1,5,3,4,11,9,4}; 
    	System.out.println(cm.maxArea(height));		
    }
}

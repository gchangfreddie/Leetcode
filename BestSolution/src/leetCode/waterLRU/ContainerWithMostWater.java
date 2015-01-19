package leetCode.waterLRU;

public class ContainerWithMostWater {
	/*
	 *  2 pointer from most left and right, because area = min(a[i], a[j])*(j-i), first we can make 
	 *  (j-i) max. then we will decrease it but make the min(a[i], a[j]) bigger to compensate
	 */
	public int maxArea(int[] height) {
        if (height.length<=1) return 0; 
        int l=0, h=height.length-1, res =0; 
        while(l<h) {
            int area = Math.min(height[l], height[h])*(h-l); 
            res = Math.max(res, area); 
            if (height[l]<height[h]) l++; 
            else h--; 
        }
        return res;
    }
}

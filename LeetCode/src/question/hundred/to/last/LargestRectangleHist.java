package question.hundred.to.last;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleHist {

	public int largestRectangleArea(int[] height) {
        int[] h = Arrays.copyOf(height, height.length+1); // we need use the dummy h[height.length]==0 to end; 
        int i=0; 
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0; 
        while(i<h.length) {
            if (stack.isEmpty() || h[i]>=h[stack.peek()]) stack.push(i++); 
            else {
                int t = stack.pop(); 
                max = Math.max(max, h[t]* (stack.isEmpty() ? i : i-stack.peek()-1)); 
            }
        }
        return max; 
    }
	
	public int largestRectangleArea2(int[] height) {
		if (height.length==0) return 0; 
        int[] h = Arrays.copyOf(height, height.length+1); 
        int max = h[0];
        for (int i=0; i<h.length-1; i++){
            if (h[i]<=h[i+1]) continue; 
            int min = h[i]; 
            int cur = 0; 
            for (int j=0; j<=i; j++) {
                min = Math.min(min, h[j]); 
                cur = Math.max(min*(i-j+1), cur); 
            }
            max = Math.max(max, cur); 
        }
        return max; 
    }
	
	public int largestRectangleArea3(int[] height) {
		if (height.length==0) return 0; 
        int max = 0 ; 
        for (int i=0; i<height.length; i++) {
            if (i<height.length-1 && height[i]<=height[i+1]) continue; // if not peak node, skip it 
            int curMax = height[i]; 
            int min = height[i]; 
            for (int j=i; j>=0; j--) { // must from current node to previous 
            	min = Math.min(height[j], min); 
                int area = (i-j+1)*min; 
                if (area>curMax) curMax=area;
            }
            if (curMax>max) max=curMax; 
        }
        return max;
    }
	
	public static void main(String[] args) {
		LargestRectangleHist lrh = new LargestRectangleHist(); 
		int[] h = new int []{2,1,5,6,2,3}; 
		int[] h1 = new int []{0,9}; 
		int res = lrh.largestRectangleArea(h)		; 
		System.out.println(res);
		}
	}

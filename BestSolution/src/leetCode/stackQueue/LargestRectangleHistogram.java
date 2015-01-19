package leetCode.stackQueue;

import java.util.*;

public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] height) {
        if (height.length==0) return 0; 
        int[] h=Arrays.copyOf(height, height.length+1); 
        int max=height[0], i=0; 
        Stack<Integer> stack = new Stack<Integer>(); 
        while (i<h.length){
            if (stack.isEmpty() || h[i]>=h[stack.peek()]) stack.push(i++); 
            else{
                int t=stack.pop(); 
                max = Math.max(max, h[t]*(stack.isEmpty() ? i : i-stack.peek()-1)); 
            }
        }
//        for (int i=0; i<h.length-1; i++){
//            if (h[i]<=h[i+1]) continue; 
//            int min=h[i]; 
//            for (int j=i; j>=0; j--){
//                min = Math.min(min, h[j]); 
//                max=Math.max(max, min*(i-j+1)); 
//            }
//        }
        return max;
    }
}

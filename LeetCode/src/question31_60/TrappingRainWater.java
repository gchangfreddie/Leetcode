package question31_60;

public class TrappingRainWater {
	public static int trap(int[] A) {
		int len = A.length; 
        if (len<=1) return 0; 
        int[] left = new int[len]; 
        int l = A[0], r=A[len-1]; 
        for (int i=0; i<len; i++) {
        	left[i]=l; 
        	if (A[i]>l) l=A[i]; 
        }
        int res = 0; 
        for (int i=len-1; i>=0; i--){
        	if (A[i]>r) r=A[i]; 
            int height = Math.min(left[i], r); 
            if (A[i]<height) res+=height-A[i]; 
        }
        return res; 
    }
	
	public static void main(String[] args){
		int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1}; 
		System.out.println(trap(a));
	}
}

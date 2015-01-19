package RecursiveAndDP;

public class TrappingRainWater {
	public int trap(int[] A) {
        if (A.length<=1) return 0; 
        int[] left = new int[A.length]; 
        int max=A[0], res=0; 
        for (int i=1; i<A.length; i++){
            max = Math.max(A[i], max); 
            left[i]=max;
        }
        max=0; 
        for (int j=A.length-1; j>=0; j--){
            max=Math.max(A[j], max); 
            int height=Math.min(left[j], max); 
            if (height>A[j]) res+=height-A[j]; 
        }
        return res;
    }
}

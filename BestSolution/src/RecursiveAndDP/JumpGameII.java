package RecursiveAndDP;

public class JumpGameII {
	public int jump(int[] A) {
        if (A==null || A.length<=1 || A[0]==0) return 0; 
        return jump(A, 0, 1); 
    }
    
    public int jump(int[] a, int index, int step){
        if (a[index]+index>=a.length-1) return step; 
        int maxReach = a[index]+index; 
        int maxIndex = index; 
        for (int i=index+1; i<=a[index]+index; i++){
            if (a[i]+i>maxReach) {
                maxReach=a[i]+i; 
                maxIndex=i; 
            }
        }
        return jump(a, maxIndex, step+1); 
    }
}

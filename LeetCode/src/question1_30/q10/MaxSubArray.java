package question1_30.q10;

public class MaxSubArray {
	public static int maxSubArray(int[] A) {
        return max(A, 0, A.length-1)[0];
    }
    
    public static  int[] max(int[] a, int s, int e) {
        int[] res = new int[3]; 
        if (s>=e) {
            res[0]=a[s]; 
            res[1]=s;
            res[2]=e;
        } else if(s<e){
            int m = s+(e-s)/2;
            int[] left = max(a, s, m); 
            int[] right = max(a, m+1, e); 
            if (left[2]+1==right[1]) {
                if (left[0]>0 && right[0]>0) {
                    res[0] = left[0]+right[0]; 
                    res[1] = left[1]; 
                    res[2] = right[2]; 
                } else {
                    res = (left[0]>right[0]) ? left : right; 
                }
            } else {
                res = (left[0]>right[0]) ? left : right; 
            }
        }
        return res;
    }
    public static int max(int[] a){
    	int max = a[0], temp = a[0]; 
    	for (int i=1; i<a.length; i++) {
    		temp = temp<0 ? a[i] : a[i]+temp; 
    		if (temp>max) max = temp; 
    	}
    	return max; 
    }
    
    public static void main(String[] args){
    	int[] array = new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4}; 
    	System.out.println(maxSubArray(array));
    	System.out.println(max(array));
    }
}

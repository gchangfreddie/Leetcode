package question1_30.q10;

public class RemoveDupInSortedArrayII {
	public static int removeDuplicates(int[] a) {
        if (a==null || a.length ==0) return 0; 
        int i=0, j=i+1, counter=1; 
        while (j<a.length) {
            if (a[i]>=a[j]) {
                if (a[i]==a[j]) counter++; 
                j++; 
            }    
            else {
                a[i+Math.min(2, counter)]=a[j]; 
//                if (counter>2) 
                	a[j] = a[i]; 
                i += Math.min(2, counter); 
                j=i+1;
                counter=1; 
            }
        }
        int[] b = new int[i+Math.min(counter, 2)]; 
        for (int k=0; k<b.length; k++) {
            b[k] = a[k]; 
        }
        return b.length; 
    }
	
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,2,3})); 
	}
}

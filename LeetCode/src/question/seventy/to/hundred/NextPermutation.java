package question.seventy.to.hundred;

import java.util.Arrays;

public class NextPermutation {
//	public void nextPermutation(int[] num) {
//		if (num==null || num.length<=1) return; 
//		for (int i=num.length-1; i>0; i--) {
//			if (num[i]>num[i-1]) {
//				// find the first greater-than-num[i-1] element
//				i-=1; 
//				for (int j=num.length-1; j>i; j--) {
//					if (num[j]>num[i]) {
//						swap(num, i, j); 
//						reverse(num, i+1); 
//						return;
//					}
//				}
//			}
//		}
//		reverse(num, 0); 
//	}
//	
//	public void reverse(int[] a, int start) {
//		int i = start, j = a.length-1; 
//		while(i<j) {
//			swap(a, i, j);
//			i++; j--; 
//		}
//	}
	
	public void swap(int[] a, int i, int j) {
		int temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp; 
	}
	
	public void nextPermutation(int[] num) {
        if (num.length<=1) return; 
        for (int i=num.length-2; i>=0; i--) {
            if (num[i]<num[i+1]) {
                int k=num.length-1; 
                while(k>=i+1) {
                    if(num[k]>num[i]) {
                        swap(num,k, i); 
                        break;
                    } 
                    k--;
                }
                sort(num, i+1, num.length-1); 
                return ;
            } 
        }
        sort(num, 0, num.length-1); 
    }
    
    public void sort(int[] a, int m, int n){
        while (m<n){
            swap(a, m++, n--); 
        }
    }
    
	public static void main(String[] args) {
		int[] num = new int[]{1,3,2}; 
		NextPermutation np = new NextPermutation(); 
		np.nextPermutation(num);
		for (int i=0; i<num.length; i++){
			System.out.print(" "+num[i]);
		}
	}
}

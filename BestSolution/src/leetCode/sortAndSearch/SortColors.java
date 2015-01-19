package leetCode.sortAndSearch;

public class SortColors {
	public void sortColors(int[] A) {
		int red=-1, blue=A.length-1; //red must be -1 instead of 0
		int cur=0; 
		while (cur<=blue) {
			if (A[cur]==0) {
				if (cur>red+1) swap(A, cur, red+1); 
				cur++; 
				red++;
			}    
			else if (A[cur]==2) {
				swap(A, cur, blue); 
				blue--; 
			} else {
				cur++; 
			}
		}
	}
	
	public void swap(int[] a, int i, int j){
		int temp = a[i]; 
		a[i]=a[j]; 
		a[j]=temp; 
	}
}

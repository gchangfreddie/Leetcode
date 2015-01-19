package Cisco;

public class SquareOfSortedArray {

	public static int[] square(int[] a){
		int[] res = new int[a.length]; 
		int i=0, k=a.length-1, m=a.length-1; 
		while (i<=k) {
			if (Math.abs(a[i])<Math.abs(a[k])) res[m--]=a[k]*a[k--]; 
			else res[m--]=a[i]*a[i++]; 
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] array = new int[]{-9, -8, -6, -4, -3, -2, 1, 2, 4, 5, 6}; 
		int[] rs = square(array); 
		for (int i : rs) {
			System.out.print(i+" ");
		}
	}

}

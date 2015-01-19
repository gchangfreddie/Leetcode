package question101_150;

import java.util.*;

public class FirstMissingPos {

	public static int firstMissingPos(int[] a) {
		if (a==null || a.length==0) return 1; 
        for (int i=0; i<a.length; i++){
			while (a[i]!= i+1 && a[i]>0 && a[i]<=a.length && a[a[i]-1]!=a[i]) { //a[a[i]-1]!=a[i] very important, otherwise unlimited loop
				swap(i, a[i]-1, a); 
			}    
		}
        for (int i=0; i<a.length; i++) {
            if (a[i]-1!=i) return i+1; 
        }
        return a.length+1; 
	}

	public static void swap(int i, int j, int[] a) {
		int temp = a[i]; 
		a[i]=a[j]; 
		a[j]=temp; 
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{-1,4,2,1,9,10}; 
		System.out.println(firstMissingPos(a));
	}
}

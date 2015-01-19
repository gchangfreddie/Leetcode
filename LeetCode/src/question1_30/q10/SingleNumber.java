package question1_30.q10;

import java.util.*;

public class SingleNumber {

	public static int singleNum(int[] a) {
		int result = 0;
		for (int i=0; i<a.length; i++) {
			result ^= a[i]; 
		}
		return result; 
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {3,5, 8, 100, 601, 601, 8, 5, 3, 6, 100}; 
		System.out.println(singleNum(a));
		
	}
}

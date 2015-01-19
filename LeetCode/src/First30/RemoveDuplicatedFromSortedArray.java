package First30;

public class RemoveDuplicatedFromSortedArray {
	public static int removeDuplicates(int[] A) {
		if (A==null ||A.length<=1 ) return A.length; 

		int i=0, cur= i+1, len=A.length; 
		while(cur<len) {
			while(cur<len&&A[cur]<=A[i]) cur++; 
			if (cur==len) break; 
			A[++i]=A[cur]; 
			cur=i+1; 
		}
		return i+1; 
	}
	public static void shift(int[] A, int start, int end, int len) {
		for (int i=end; i<len; i++) {
			A[start++] = A[i]; 
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,2,2,3,4,4,4,4,4,5,6,7}; 
		int b = removeDuplicates(array); 
		System.out.println(b);
	}
}

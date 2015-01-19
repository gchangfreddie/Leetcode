package First30;

public class RemoveDuplicatedFromSortedArrayII {
	public static int removeDuplicates(int[] A) {
		if (A.length<=2) return A.length; 
		int curValue = A[0], curPoint = 1, tail = 1;
		while(curPoint<A.length){
			if (A[curPoint]==curValue) {
				A[tail++]=A[curPoint++];
				while(curPoint<A.length && A[curPoint]==curValue) curPoint++; 
			}
			if (curPoint<A.length){
				curValue = A[curPoint++]; 
				A[tail++] = curValue;
			}       
		}
		return tail; 
	}

	public static void main(String[] args) {
		int[] array = new int[] {1,2,2,2}; 
		int b = removeDuplicates(array); 
		System.out.println(b);
	}
}

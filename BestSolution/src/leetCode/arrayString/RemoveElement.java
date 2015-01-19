package leetCode.arrayString;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int i=0, j=A.length-1; 
		while (i<=j) {
			if (A[i]==elem) {
				A[i]=A[j--]; 
			} else {
				i++; 
			}    
		}
		return j+1;
	}
}

package algorithm.groupon;

public class Convert {
	public static int[] convert(int[] a){
		int j=a.length-1; 
		while (j>=0) {
			if (a[j]>0) {
				a[j]-=1; 
				break;
			}
			else {
				a[j--]=9; 
			}  
		}
		int i=0; 
		for (; i<a.length; i++) {
			if (a[i]!=0) break;
		}
		int[] res = new int[Math.max(a.length-i, 1)]; 
		int k=0; 
		for (; i<a.length; i++) {
			res[k++]=a[i]; 
		}
		return res; 
	}

	public static void main(String[] args){
		int[] a = new int[]{1, 0, 0}; 
		int[] res = convert(a); 
		for (int i: res) 
			System.out.print(i + " ");
	}

}

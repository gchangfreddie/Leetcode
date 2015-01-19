package question.hundred.to.last;

public class FindMisssingPositive {

	public static int find(int[] a) {
		if (a==null || a.length == 0) return 0; 
		int res = 0; 
		for (int i=0; i<a.length; i++) {
			res ^=a[i]; 
		}
		return res; 
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{0, 2}; 
		System.out.println(find(a));
	}
}

package leetCode.bitManipulation;

public class AddBinary {
	public String addBinary(String a, String b) {
		a = new StringBuilder(a).reverse().toString(); 
		b = new StringBuilder(b).reverse().toString(); 
		int i=0, j=0, c=0;
		StringBuilder res = new StringBuilder(); 
		while (i<a.length() || j<b.length() || c!=0){
			int v1 = i<a.length() ? a.charAt(i)-'0' : 0; 
			int v2 = j<b.length() ? b.charAt(j)-'0' : 0; 
			int sum = v1+v2+c;
			c=sum/2; 
			res.append(sum%2); 
			i++; j++; 
		}
		return res.reverse().toString(); 
	}
}

package RecursiveAndDP;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s.length()==0 || s.charAt(0)=='0') return 0; 
		int[] count= new int[2]; 
		count[0]=1; count[1]=1;
		for (int i=1; i<s.length();i++){
			char ch = s.charAt(i); 
			int temp =0; 
			if (ch!='0') temp=count[1]; 
			int t = Integer.parseInt(s.substring(i-1, i+1));
			if (s.charAt(i-1)!='0'&&t<=26 && t>=1) temp+=count[0]; 
			count[0]=count[1];
			count[1]=temp; 
		}
		return count[1]; 
	}
}

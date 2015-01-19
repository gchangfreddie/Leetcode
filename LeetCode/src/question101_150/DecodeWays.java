package question101_150;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s==null || s.length()==0) return 0; 
        int len = s.length(); 
        if (s.charAt(0)=='0' ) return 0; 
        int[] num = new int[2]; 
        num[0]=1; 
        num[1]=1; 
        for (int i=0; i<len; i++) {
            int temp = 0; 
            char c = s.charAt(i); 
            if (c!='0') temp = num[1]; 
            if (i>0) {
                int v = Integer.parseInt(s.substring(i-1, i+1)); 
                if (s.charAt(i-1)!='0' && v>0 && v<27) temp +=num[0]; 
            }
            num[0]=num[1]; 
            num[1]=temp;
        }
        return num[1]; 
    }
	
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays(); 
		System.out.println(dw.numDecodings("1904"));
	}
}

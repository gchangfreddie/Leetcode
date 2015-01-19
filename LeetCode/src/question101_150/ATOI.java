package question101_150;

public class ATOI {
	public int atoi(String str) {
		str = str.trim(); 
        if (str.length()==0) return 0;
        char c = str.charAt(0); 
        int neg = c=='-' ? -1 : 1; 
        int i = (c=='-' || c=='+') ? 1 : 0; 
        long res = 0; 
        while(i<str.length()) {
            c = str.charAt(i++); 
            if (c<'0' || c>'9') break; 
            else res = res*10 + (c-'0'); 
        } 
        res *=neg;
        if (res>Integer.MAX_VALUE) res = Integer.MAX_VALUE; 
        if (res<Integer.MIN_VALUE) res = Integer.MIN_VALUE; 
        return (int)res; 
    }
	
	public static void main(String[] args) {
		ATOI atoi = new ATOI(); 
		String s = " -11919730356x";
		System.out.println(atoi.atoi("    010"));
	}
}

package leetCode.arrayString;

public class Atoi {
	public static int atoi(String str) {
		str = str.trim(); 
        if (str.length()==0) return 0; 
        int i=0, neg=1;
        if (str.charAt(0)=='+' || str.charAt(0)=='-') {
            if (str.length()==1) return 0;
            i++; neg=str.charAt(0)=='-'? -1 : 1;
        }
        int res=0;
        while (i<str.length()){
            char ch = str.charAt(i); 
            if (ch<'0' || ch>'9') break; 
            if (neg==1) {
                if (res>(Integer.MAX_VALUE-(ch-'0'))/10) return Integer.MAX_VALUE;
            } else {
                if (res*neg<(Integer.MIN_VALUE+(ch-'0'))/10) return Integer.MIN_VALUE;
            }
            res=res*10+(ch-'0'); 
            i++; 
        }
        return res*neg;
    }
	
	public static void main(String[] args){
		System.out.println(atoi("-1")); 
	}
}

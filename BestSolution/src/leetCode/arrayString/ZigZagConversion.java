package leetCode.arrayString;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
        if (s.length()==0 || nRows<=1) return s; 
        StringBuilder[] array = new StringBuilder[nRows]; 
        for (int i=0; i<nRows; i++) array[i]=new StringBuilder(); 
        int d = -1, r=0; // d init must be -1, for the first char
        for (int i=0; i<s.length(); i++){
            char c=s.charAt(i); 
            array[r].append(c); 
            if (r==nRows-1 || r==0) {
                d*=-1; 
            }  
            r = d==1 ? r+1 : r-1; 
        }
        StringBuilder res = new StringBuilder(); 
        for (int i=0; i<nRows; i++) {
            res.append(array[i].toString()); 
        }
        return res.toString(); 
    }
	
	public static void main(String[] args){
		ZigZagConversion zz = new ZigZagConversion(); 
		System.out.println(zz.convert("AB", 1));
	}
}

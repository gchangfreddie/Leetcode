package question91_100;

import java.util.*;

public class ZigZagConversion {
	public static String convert(String s, int nRows) {
		if (s.length()<=nRows) return s; 
        String[] sArray = new String[nRows]; 
        for (int i=0; i<sArray.length; i++) sArray[i]="";
        char[] cArray = s.toCharArray(); 
        int direction = -1, row = 0;  
        for (int i=0; i<cArray.length; i++) {
            sArray[row]+=String.valueOf(cArray[i]); 
            if (nRows!=1) {
                if (row==0 || row==nRows-1) {
                    direction*=-1; 
                }
                row = direction>0 ? row+1 : row-1; 
            }
        }
        StringBuilder sb = new StringBuilder(); 
        for (int i=0; i<sArray.length; i++){
            sb.append(sArray[i]); 
        }
        return sb.toString(); 
    }
	
	public static void main(String[] args) {
		System.out.println(convert("ABC", 2));
		System.out.println(convert("PAYPALISHIRING", 2));
	}
}

package leetCode.arrayString;

public class RomanToInt {
	public static int romanToInt(String s) {
		String roman = new String("IVXLCDM");
        int res=0; 
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i); 
            int d = roman.indexOf(ch); 
            int e = i<s.length()-1 ? roman.indexOf(s.charAt(i+1)) : -1;
            boolean add = e<=d;
            switch (ch) {
                case 'M' : res+=1000; break;
                case 'C' : res = add ? res+100 : res-100;  break;
                case 'D' : res = add ? res+500 : res-500; break;
                case 'L' : res = add ? res+50 : res-50; break;
                case 'X' : res = add ? res+10: res-10; break;
                case 'V' : res = add ? res+5 : res-5; break;  
                case 'I' : res = add ? res+1 : res-1; break;               
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		System.out.println(romanToInt("DCXXI"));
		
		
	}
}

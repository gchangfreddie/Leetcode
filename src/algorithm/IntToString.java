package algorithm;

public class IntToString {
	public String intToString(int number){
		if (number==0) return "0"; 
		boolean neg = number>0 ? false: true; 
		number = neg? -number : number; 
	    StringBuilder sb = new StringBuilder(); 
	    while (number!=0) {
	        int n = number%10; 
	        number = number/10; 
	        char c = inToChar(n); 
	        sb.insert(0, c); 
	    }
	    String res = sb.toString(); 
	    if (neg ) return "-"+res;
	    return res;
	}
	
	public char inToChar(int number){
		return Character.forDigit(number, 10); 
//		return (char)(number+48); 
	}
	
	public static void main(String[] args){
		IntToString stt = new IntToString(); 
		System.out.println(stt.inToChar(12));
	}
}

package question31_60;

public class IntToRoman {
	 public static String intToRoman(int num) {
			int mod = 1000;
			StringBuffer sb = new StringBuffer();
			int d=0;
			while (mod!=0) {
				d=num/mod; 
				if (d!=0) {
					switch (d) {
					case 4: 
						if (mod==100) sb.append("CD");  
						else if (mod==10) sb.append("XL");
						else sb.append("IV"); 
						break;
					case 9:
						if (mod==100) sb.append("CM");  
						else if (mod==10) sb.append("XC");
						else sb.append("IX"); 
						break; 
					default :
						if (mod==1000) {
							for (int i=0; i<d; i++) {
							    sb.append("M");  
							}
						}	
						else if (mod==100) {
							render(sb, d, 'D', 'C');
						}else if (mod==10) {
							render(sb, d, 'L', 'X'); 
						} else if (mod==1) {
							render(sb, d, 'V', 'I'); 
						}
					}		

				}
				num = num % mod;
				mod/=10; 
			}
			return sb.toString(); 
		}

	private static void render(StringBuffer sb, int d, char h, char l) {
		if (d>=5) sb.append(h); 
		d%=5;
		for (int i=0; i<d; i++) {
			sb.append(l); 
		}
	}
	 
	 public static void main(String[] args) {
		 System.out.println(intToRoman(60));
	 }
	 
}

package leetCode.arrayString;

public class IntToRoman {
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder(); 
		String[][] roman = new String[][]{{"I", "V"},{"X","L"}, {"C","D"}, {"M"}};  
		int index=0; 
		while (num!=0) {
			int n = num%10; 
			if (n<4) for (int i=0; i<n; i++) sb.insert(0, roman[index][0]);
			else if (n==4) {
				sb.insert(0, roman[index][1]); sb.insert(0, roman[index][0]); 
			} else if (n<9) {
				for (int i=6; i<=n; i++) sb.insert(0, roman[index][0]);
				sb.insert(0, roman[index][1]); 
			} else {
				sb.insert(0, roman[index+1][0]);         
				sb.insert(0, roman[index][0]);       
			}
			num/=10; index++; 
		}
		return sb.toString(); 
	}
}

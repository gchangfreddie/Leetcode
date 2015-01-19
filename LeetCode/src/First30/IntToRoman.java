package First30;

public class IntToRoman {
	 public static String intToRoman1(int num) {
	        String[][] array = new String[][]{{"I","V"}, {"X","L"},{"C","D"},{"M",""}}; 
	        String sb = new String(); 
	        int index = 0; 
	        while (num!=0) {
	            int cur = num%10; 
	            num=num/10; 
	            if (cur<4) {
	                for (int i=0; i<cur; i++) {
	                    sb=array[index][0]+sb;
	                }
	            } else if (cur<9) {
	                if (cur<5) sb=array[index][0]+array[index][1]+sb; 
	                else {
	                    String temp = array[index][1]; 
	                    for (int i=0; i<cur-5; i++) {
	                        temp +=array[index][0]; 
	                    }
	                    sb=temp+sb; 
	                }
	            } else {
	                sb = array[index][0]+array[index+1][0] + sb; 
	            }
	            index++; 
	        }
	        return sb; 
	    }
	
	public static void main(String[] args) {
		System.out.println(intToRoman1(4));
	}
}

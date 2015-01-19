package leetCode.arrayString;

public class MultiplyString {
	public String multiply(String num1, String num2) {
        if (num1.length()==0 || num2.length()==0) return ""; 
        num1 = new StringBuilder(num1).reverse().toString(); 
        num2 = new StringBuilder(num2).reverse().toString(); 
        int[] res = new int[num1.length()+num2.length()]; 
        for (int i=0; i<num1.length(); i++){
            for (int j=0; j<num2.length(); j++)
                res[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        }
        
        StringBuilder sb=new StringBuilder();
        int c=0;
        for (int i=0; i<res.length; i++) {
            res[i]+=c;
            c = res[i]/10;
            sb.append(res[i]%10); 
        }
        sb.reverse(); 
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0); 
        return sb.toString(); 
    }
}

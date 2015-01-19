package question101_150;

public class MultiplyStr {
	public String multiply(String num1, String num2) {
		if (num1.length()==0 || num2.length()==0) return ""; 
        StringBuilder sb = new StringBuilder(num1); 
        num1 = sb.reverse().toString(); 
        sb=new StringBuilder(num2); 
        num2 = sb.reverse().toString(); 
        int[] res = new int[num1.length()+num2.length()]; 
        for (int i=0; i<num1.length(); i++){
            for (int j=0; j<num2.length(); j++)
                res[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        }
        
        sb=new StringBuilder();
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
	
	public String multiply1(String num1, String num2) {
        if (num1.length()==0 || num2.length()==0) return null; 
        num1 = new StringBuilder(num1).reverse().toString(); 
        num2 = new StringBuilder(num2).reverse().toString(); 
        int len1 = num1.length(), len2=num2.length(); 
        int[] sum= new int[len1+len2]; 
        for (int i=0; i<len1; i++){
            int c1 = num1.charAt(i)-'0';
            for (int j=0; j<len2; j++) {
                int c2=num2.charAt(j)-'0'; 
                sum[i+j]+=c1*c2;
            }
        }
        int c=sum[0]/10, i=1; 
        sum[0]%=10; 
        while(i<sum.length && (sum[i]!=0 || c!=0)){
            sum[i]+=c; 
            c=sum[i]/10; 
            sum[i++]%=10; 
        }
        StringBuilder sb = new StringBuilder(); 
        boolean b = false; 
        for (i=sum.length-1; i>=0; i--){
            if (sum[i]==0 && !b) continue; 
            b=true; 
            sb.append(String.valueOf(sum[i])); 
        }
        return sb.length()==0 ? "0" : sb.toString(); 
    }
	
	public static void main(String[] args) {
		MultiplyStr mstr = new MultiplyStr(); 
		System.out.println(mstr.multiply1("98", "9"));
	}
}


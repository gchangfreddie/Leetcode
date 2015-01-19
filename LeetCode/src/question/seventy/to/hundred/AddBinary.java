package question.seventy.to.hundred;

public class AddBinary {
	public String addBinary(String a, String b) {
        if (a==null || a.length()==0 ) return b; 
        if (b==null || b.length()==0) return a; 
        StringBuffer sb = new StringBuffer(); 
        int len = Math.max(a.length(), b.length()); 
        if (a.length()!=len) {
           a = appendZero(a, len); 
        } else if (b.length()!=len) {
            b = appendZero(b, len); 
        }
        boolean carry = addString(a, b, 0, sb, len ); 
        if (carry) sb.insert(0, '1'); 
        return sb.toString(); 
    }
    
    public String appendZero(String s, int len){
        StringBuffer sb = new StringBuffer(s);
        for (int i=0; i<len-s.length(); i++) {
            sb.insert(0,'0');
        }
        return sb.toString(); 
    }
    
    public boolean addString(String s1, String s2, int i, StringBuffer sb, int length){
        if (i==length) return false;
        char c1 = s1.charAt(i); 
        char c2 = s2.charAt(i); 
        boolean carry = addString(s1, s2, i+1, sb, length); 
        if (carry) {
            if (c1=='1') {
                sb.insert(0, c2); 
                return true; 
            } else if (c2=='1') {
                sb.insert(0, c1); 
                return true;
            } else {
                sb.insert(0, '1'); 
                return false; 
            }   
        } else {
            if (c1 == '1' && c2 =='1') {
                sb.insert(0, '0'); 
                return true;
            } else {
                sb.insert(0, c1=='0' ? c2 : c1); 
                return false; 
            }
        }
    }
    
    public static void main(String[] args) {
    	AddBinary ab = new AddBinary(); 
    	System.out.println(ab.addBinary1("0", "0"));
    	char c = '1'; 
    	int a = c-'0'; 
    	System.out.println(a);
    }
    
    public String addBinary1(String a, String b) {
        a = new StringBuilder(a).reverse().toString(); 
        b = new StringBuilder(b).reverse().toString(); 
        StringBuilder res = new StringBuilder(); 
        int c=0, i=0, j=0; 
        while(i<a.length()|| j<b.length() || c!=0){
            int c1 = i<a.length() ? a.charAt(i)-'0': 0; 
            int c2 = j<b.length() ? b.charAt(j)-'0': 0; 
            int sum = c1+c2+c;
            c=sum/2;
            res.append(String.valueOf(sum%2));
            i=i<a.length() ? i+1 : i;
            j=j<b.length() ? j+1 : j; 
        }
        return res.reverse().toString(); 
     }
}

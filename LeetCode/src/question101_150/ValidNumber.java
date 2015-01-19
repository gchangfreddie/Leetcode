package question101_150;

public class ValidNumber {
	public boolean isNumber(String s) {
		if (s==null || s.length()==0) return false; 
		s = s.trim(); 
		if (s.contains(" ")) return false; 
		boolean real = false; 
		boolean e = false; 
		boolean n = false; 
		boolean valid = true; 
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i); 
			if (c>='0' && c<='9') {
				n=true; 
				if (e) valid = true; 
				continue; 
			}
			if (c=='.'){ 
				if(!real && !e) real=true; 
				else return false; 
			} else if (c=='e'){
				if (i==0 || e || i==s.length()-1 ||!n) return false; 
				else {
					e=true;
					valid = false; 
				}
			} else if (c=='+' || c=='-') {
				if (i!=0 && s.charAt(i-1)!='e') 
					return false; 
			} else return false; 
		}
		if(!n) return false;
		else if(e && !valid) return false; 
		return true; 
	}

	public boolean isNumber1(String s) {
		s=s.trim();  
        if (s.contains(" ")) return false; 
        if (s.length()==0) return false; 
        boolean dec=false, e=false, n=false, valid=true;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i); 
            if (c>='0' && c<='9') {
                n=true;
                if(e) valid=true; 
            } else if (c=='.') {
                if (dec || e ) return false;
                dec=true;
            } else if (c=='e') {
                if (i==0 || e || i==s.length()-1 || !n) return false; 
                e=true;
                valid=false;
            } else if (c=='-' || c=='+'){
                if (i!=0 && s.charAt(i-1)!='e') return false;
            }
            else return false; 
        }
        if (!n) return false;
        if (e&&!valid) return false;
        return true;
	}

	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber(); 
		vn.isNumber("4e+"); 
		System.out.println(vn.isNumber("0"));
		System.out.println(vn.isNumber(" 0.1 "));
		System.out.println(vn.isNumber("abc"));		
		System.out.println(vn.isNumber("1 a"));
		System.out.println(vn.isNumber("2e10"));
		System.out.println(vn.isNumber("005047e+6"));

	}
}

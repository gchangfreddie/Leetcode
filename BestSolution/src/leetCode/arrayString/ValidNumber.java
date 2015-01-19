package leetCode.arrayString;

public class ValidNumber {
    public boolean isNumber(String s) {
        s=s.trim(); 
        if (s.length()==0 || s.contains(" ")) return false;
        boolean valid=false, decimal=false, e=false;
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i); 
            if (!(c>='0'&&c<='9')) {
                switch (c) {
                    case '.': if (!e && !decimal) { decimal=true; break; }
                              else return false; 
                    case 'e': if (!e && i!=0 && valid) {e=true; valid=false; break;}
                              else return false;
                    default : if (c=='+' || c=='-') {
                                 if (i!=0 && s.charAt(i-1)!='e') return false;
                              }
                              else return false;
                }
            } else {
                valid=true;
            }
        }
        return valid;
    }

}

package question.sixty.to.seventy;

public class CountAndSay {
	public static String countAndSay(int n) {
        String s="1"; 
        for (int i=2; i<=n; i++) {
            char pre = s.charAt(0); 
            char count = '1' ;
            StringBuilder sb = new StringBuilder(); 
            for (int j=1; j<s.length(); j++){
                char c = s.charAt(j); 
                if (c==pre) count++; 
                else {
                    sb.append(count); 
                    sb.append(pre);
                    pre=c; 
                    count='1'; 
                }
            }
            sb.append(count); 
            sb.append(pre); 
            s=sb.toString(); 
        }
        return s;
    }
	
	public static void main(String[] args){
		System.out.println(countAndSay(5));
		System.exit(1);
	}
}

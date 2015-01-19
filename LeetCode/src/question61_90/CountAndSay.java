package question61_90;

public class CountAndSay {
	public String countAndSay(int n) {
	       if (n==1) return "1";  
	       return parse(countAndSay(n-1)); 
	    }
	    
	    
	    public String parse(String s) {
	        char prev = s.charAt(0);
	        int count = 0; 
	        StringBuffer sb = new StringBuffer(); 
	        for (int i=0; i<s.length(); i++) {
	            if (prev==s.charAt(i)) {
	                count++; 
	            } else {
	                sb.append(count); 
	                sb.append(prev); 
	                count=1; 
	                prev = s.charAt(i); 
	            }
	        }
	        sb.append(count); 
	        sb.append(prev); 
	        return sb.toString(); 
	    }
	    
	    public static void main(String[] args) {
	    	System.out.println(new CountAndSay().countAndSay(4));
	    }
}

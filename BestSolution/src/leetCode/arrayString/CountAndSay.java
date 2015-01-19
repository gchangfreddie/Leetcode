package leetCode.arrayString;
public class CountAndSay {
	public String countAndSayRecursive(int n) {
        if (n==1) return "1"; 
        String prev=countAndSayRecursive(n-1); 
        StringBuilder sb = new StringBuilder(); 
        for (int i=0; i<prev.length(); i++) {
            char p = prev.charAt(i); 
            int count=1; 
            while(i<prev.length()-1 && p == prev.charAt(i+1)) {
                i++; count++; 
            }
            sb.append(count); sb.append(p); 
        }
        return sb.toString(); 
    }
	
	public String countAndSay(int n) {
        String res = new String("1"); 
        int count=1; 
        while (count<n) {
            StringBuilder sb = new StringBuilder(); 
            int c=1; 
            for (int i=0; i<res.length(); i++){
               while (i<res.length()-1 && res.charAt(i)==res.charAt(i+1)){
                   c++; 
                   i++; 
               }
               sb.append(c); sb.append(res.charAt(i)); 
               c=1; 
            }
            count++; 
            res=sb.toString(); 
        }
        return res; 
    }
}

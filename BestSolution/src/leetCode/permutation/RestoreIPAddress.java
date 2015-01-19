package leetCode.permutation;

import java.util.*;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>(); 
        int len=s.length(); 
        if (len<4 || len>12) return res; 
        restore(s, res, "", 0, len);
        return res; 
    }	 
    
    public void restore(String s, List<String> res, String prefix, int level, int len){
        if (level==4 && len==0) {
            res.add(prefix.substring(0, prefix.length()-1)); 
        } else {
            for (int i=1; i<=Math.min(3, len); i++) {
                String ip = s.substring(0, i); 
                if (Integer.parseInt(ip)>255) break; 
                if (ip.length()>1 && ip.charAt(0)=='0') break; 
                restore(s.substring(i), res, prefix+ip+".", level+1, len-i); 
            }
        }
    }
}

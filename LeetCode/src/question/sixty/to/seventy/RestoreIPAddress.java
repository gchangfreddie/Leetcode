package question.sixty.to.seventy;

import java.util.*;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>(); 
        int len = s.length(); 
        if (len>12 || len<4 ) return res; 
        restore(s, 0, "", res); 
        return res;
    }
    
    public void restore(String s, int level, String ip, List<String> res) {
    	if (level==4) {
            if (s.length()==0) res.add(ip); 
            return ; 
        } 
        int limit=4-level;
        if (s.length()<limit || s.length()>limit*3) return ;
        for (int i=1; i<=3 && i<=s.length(); i++) {
            String tempIP = s.substring(0, i); 
            if (Integer.parseInt(tempIP)>255) break;
            tempIP = level==0 ? tempIP : ip+"."+tempIP; 
            restore(s.substring(i), level+1, tempIP, res);
            if (s.charAt(0)=='0') break; 
        }
    }
    
    public static void main(String[] args) {
    	RestoreIPAddress ra = new RestoreIPAddress(); 
    	List<String> list = ra.restoreIpAddresses("010010"); 
    	for (String s : list) System.out.println(s);
    }
}

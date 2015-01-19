package question101_150;

import java.util.*;

public class RestoreIP {
	 public List<String> restoreIpAddresses(String s) {
		 if (s.length()<4 || s.length()>12) return new ArrayList<String>(); 
		 List<String> res = restoreIpAddresses(s, 1); 
		 return res; 
	 }
	 
	 public List<String> restoreIpAddresses(String s, int layer) {
		 List<String> res = new ArrayList<String>(); 
		 for (int i=0; i<Math.min(3, s.length()); i++) {
			 String str1 = s.substring(0, i+1); 
			 if (i!=0 && str1.charAt(0)=='0') continue; 
			 int address = Integer.parseInt(str1); 
			 if (address>=0 && address<=255) {
				 if (layer==4 && i==s.length()-1) res.add(address+"");
				 else {
					 List<String> list = restoreIpAddresses(s.substring(i+1), layer+1);
					 if (res!=null && list.size()>0){
						 for (String str : list) {
							 str = address + "." + str;
							 res.add(str); 
						 }
					 }
				 }
			 }
		 }
		 return res; 
	 }
	 
	 public static void main(String[] args) {
		 RestoreIP rip = new RestoreIP(); 
		 List<String> res = rip.restoreIpAddresses("010010"); 
		 for (String s : res) {
			 System.out.println(s);
		 }
	 }
}

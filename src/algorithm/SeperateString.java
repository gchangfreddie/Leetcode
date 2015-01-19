package algorithm;

import java.util.*;

public class SeperateString{
    public static List<String> convert(String s){
        List<String> res = new ArrayList<String>(); 
        if (s==null || s.length()==0) return res;
        StringBuilder sb = new StringBuilder(); 
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i); 
            if (!(c>='a'&&c<='z') || (i>0 &&c!=s.charAt(i-1)+1)) {
                if (sb.length()>0) { 
                	res.add(sb.toString()); 
                	sb=new StringBuilder(); 
                } 
            }    
            if (c>='a'&&c<='z') sb.append(c); 
        }
        res.add(sb.toString()); 
        return res;
    }
    public static void main(String[] args){
        List<String> res = convert("123abc1dexyz"); 
        for (String s : res) System.out.println(s + " " + s.length()); 
    }
}

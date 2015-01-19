package question1_30.q10;

import java.util.*;

public class PasicalTrianglesII {
    
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(); 
        list.add(1); 
        if (rowIndex==0) return list;
        for (int i=1; i<=rowIndex; i++) {
            list.add(1, list.size()==1 ? 1 : list.get(0)+list.get(1)); 
            for (int j=2; j<list.size()-1; j++){
               list.set(j, list.get(j)+list.get(j+1));  
            }
        }
        return list; 
    }
    
    public static void main(String[] args) {
    	List<Integer> a = getRow(4); 
    	System.out.println(a);
    	System.exit(0);
    }
}

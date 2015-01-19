package First30;

import java.util.*;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
//        ArrayList<Integer> a = new ArrayList<Integer>(); 
//        if (n==0) {
//            a.add(0);return a; 
//        }    
//        if (n==1) {
//            a.add(0); 
//            a.add(1); 
//            return a; 
//        }
//        ArrayList<Integer> b = grayCode(n-1); 
//        int count=0; 
//        for (int i : b) {
//            if(count%2==0) {
//                a.add((i<<1)|0);
//                a.add((i<<1)|1); 
//            } else {
//                a.add((i<<1)|1);
//                a.add((i<<1)|0); 
//            }
//            count++; 
//        }
//        return a; 
		List<Integer> res = new ArrayList<Integer>(); 
        if (n==0) {
            res.add(0); 
            return res; 
        }
        List<Integer> prev = grayCode(n-1); 
        int temp = 1<<(n-1); 
        res.addAll(prev); 
        for (int i=prev.size()-1; i>=0; i--){
            res.add(temp+prev.get(i)); 
        }
        return res; 
    }
	
	public static void main(String[] args) {
		List<Integer> res = grayCode(3); 
		for (int a : res) System.out.print(a + " ");
		System.exit(0);
	}
}

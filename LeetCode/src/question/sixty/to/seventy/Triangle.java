package question.sixty.to.seventy;

import java.util.*; 
public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> res = new ArrayList<Integer>(triangle.get(0)); 
        for (int i=1; i<triangle.size(); i++) {
            List<Integer> temp = triangle.get(i); 
            res.add(0, temp.get(0)+res.get(0)); 
            int j=1; 
            for (; j<temp.size()-1; j++) {
                res.set(j, Math.min(res.get(j), res.get(j+1)) + temp.get(j)); 
            }
            res.set(j, res.get(j)+temp.get(j)); 
        }
        int min = Integer.MAX_VALUE;
        for (Integer a : res) {
            if (a<min) min=a; 
        }
        return min; 
    }
	
	public static void main(String[] args) {
		List<List<Integer>> t = new ArrayList<List<Integer>>(); 
		ArrayList<Integer> top = new ArrayList<Integer>(); 
		top.add(2); 
		ArrayList<Integer> bottom = new ArrayList<Integer>(); 
		bottom.add(3); bottom.add(4); 
		ArrayList<Integer> bottom1 = new ArrayList<Integer>(); 
		bottom1.add(6); bottom1.add(5); bottom1.add(7); 
		ArrayList<Integer> bottom2 = new ArrayList<Integer>(); 
		bottom2.add(4); bottom2.add(1); bottom2.add(8); bottom2.add(3); 
		t.add(top); t.add(bottom); t.add(bottom1); t.add(bottom2); 
		System.out.println(minimumTotal(t));
	}
	
}

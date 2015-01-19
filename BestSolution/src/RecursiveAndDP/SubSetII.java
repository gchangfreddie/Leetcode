package RecursiveAndDP;
import java.util.*;
public class SubSetII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        res.add(new ArrayList<Integer>()); 
        if (num.length==0)  return res; 
        Arrays.sort(num); 
        List<List<Integer>> tempRes = new ArrayList<List<Integer>>(); 
        for (int i=0; i<num.length; i++) {
            if (i==0 || num[i]!=num[i-1]){
                tempRes.clear(); 
                for (List<Integer> list : res) tempRes.add(new ArrayList<Integer>(list)); 
            }
            for (List<Integer> list : tempRes) {
                list.add(num[i]); 
                res.add(new ArrayList<Integer>(list)); 
            }
        }
        return res; 
    }
}

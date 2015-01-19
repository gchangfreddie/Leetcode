package leetCode.permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationII {
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if (num.length==0) return res;
        boolean[] visited = new boolean[num.length]; 
        construct(num, res, new ArrayList<Integer>(), 0, visited); 
        return res;
    }
    
    public void construct(int[] a, List<List<Integer>> res, List<Integer> list, int index, boolean[] visited) {
        if (index==a.length) {
            res.add(new ArrayList<Integer>(list)); 
            return ;
        }
        for (int i=0; i<a.length; i++) {
            if (!visited[i]) {
                visited[i]=true; 
                list.add(a[i]); 
                construct(a, res, list, index+1, visited);
                list.remove(list.size()-1);
                visited[i]=false; 
            }
        }
    }
}

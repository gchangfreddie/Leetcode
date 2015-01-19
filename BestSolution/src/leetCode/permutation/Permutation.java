package leetCode.permutation;
import java.util.*;

public class Permutation {
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
    
    public List<List<Integer>> permute1(int[] num) {
        return permute(num, num.length-1); 
    }
    public List<List<Integer>> permute(int[] a, int d){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (d==0){
            List<Integer> list = new ArrayList<Integer>(); 
            list.add(a[d]); 
            res.add(list); 
        } else{
            List<List<Integer>> prev = permute(a,d-1); 
            for (List<Integer> list : prev){
                for (int i=0; i<=list.size(); i++){
                    List<Integer> temp = new ArrayList<Integer>(list); 
                    temp.add(i, a[d]); 
                    res.add(temp); 
                }
            }
        }
        return res;
    }
}

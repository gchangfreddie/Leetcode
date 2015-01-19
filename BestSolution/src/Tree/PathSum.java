package Tree;
import java.util.*;
public class PathSum {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		if (root==null) return res; 
		List<Integer> list = new ArrayList<Integer>(); 
		list.add(root.val); 
		pathSum(root, sum-root.val, res, list); 
		return res; 
	}

	public static void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
		if (root.left==null && root.right==null) {
			if (sum==0) res.add(new ArrayList<Integer>(list)); 
		} else {
			if (root.left!=null) {
				list.add(root.left.val); 
				pathSum(root.left, sum-root.left.val, res, list); 
				list.remove(list.size()-1); 
			} 
			if (root.right!=null){
				list.add(root.right.val); 
				pathSum(root.right, sum-root.right.val, res, list); 
				list.remove(list.size()-1); 
			} 
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(0); 
    	TreeNode node1 = new TreeNode(1); 
    	TreeNode node2 = new TreeNode(1); 
    	root.left = node1;
    	root.right = node2;
    	List<List<Integer>> rs = pathSum(root, 1);
    	for (List<Integer> l : rs) {
    		System.out.println(l);
    	}
	}

}

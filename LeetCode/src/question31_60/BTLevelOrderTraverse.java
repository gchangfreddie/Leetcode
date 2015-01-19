package question31_60;
import java.util.*;
public class BTLevelOrderTraverse {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> alal = new ArrayList<ArrayList<Integer>>(); 
        ArrayList<Integer> al = new ArrayList<Integer>(); 
        alal.add(al); 
        if (root== null) return alal; 
        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>(); 
        q1.add(root); 
        traverse(q1, new LinkedList<TreeNode>(), alal); 
        return alal; 
    }
    
    private void traverse(LinkedList<TreeNode> q1, LinkedList<TreeNode> q2, ArrayList<ArrayList<Integer>> alal) {
        if (q1==null || q1.size()==0) return ;
        ArrayList<Integer> list = alal.get(alal.size()-1); 
        while(!q1.isEmpty()) {
            TreeNode root = q1.pop(); 
            if (root.left!=null) q2.add(root.left); 
            if (root.right!=null) q2.add(root.right); 
            list.add(root.val); 
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        alal.add(al); 
        traverse(q2, new LinkedList<TreeNode>(), alal); 
    }

    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    
    public static void main(String[] args) {
    	
    }
}

package question1_30.q10;

import java.util.LinkedList;

public class SymmeticTree {
	public boolean isSymmetric(TreeNode root) {
		if (root==null) return false; 
		return compare(root.left, root.right); 
	}

	public boolean compare(TreeNode left, TreeNode right) {
		if (left==null && right== null) return true;
		if ((left==null || right==null) || left.val != right.val) return false;

		return compare(left.left, right.right) && compare(left.right, right.left); 
	}
	
	public boolean isSymmetric1(TreeNode root) { // keep 2 separate queue for left and right subtree, Queue can add
		//multiple null
        if (root==null) return true;
        LinkedList<TreeNode> l = new LinkedList<TreeNode>(), r = new LinkedList<TreeNode>(); 
        l.add(root.left); r.add(root.right); 
        while(!l.isEmpty() && !r.isEmpty()){
            TreeNode left = l.poll(), right = r.poll(); 
            if ((left==null && right!=null) || (left!=null) && (right==null)) return false; 
            if (left!=null) {
                if (left.val != right.val) return false; 
                l.add(left.left); 
                l.add(left.right); 
                r.add(right.right); 
                r.add(right.left); 
            }
        }
        return true; 
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

package Tree;

import java.util.*;
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root==null || (root.left==null && root.right==null)) return true; 
        return isSym(root.left, root.right); 
    }
    
    public boolean isSym(TreeNode left, TreeNode right){
        if (left==null) return right==null; 
        if (right==null) return left==null; 
        if (left.val!=right.val) return false; 
        return isSym(left.right, right.left) && isSym(left.left, right.right); 
    }
    
    public boolean isSymmetric1(TreeNode root) {
        if (root==null || (root.left==null && root.right==null)) return true; 
        LinkedList<TreeNode> qLeft = new LinkedList<TreeNode>(); 
        LinkedList<TreeNode> qRight = new LinkedList<TreeNode>(); 
        qLeft.add(root.left); 
        qRight.add(root.right); 
        while(!qLeft.isEmpty() && !qRight.isEmpty()) {
            TreeNode left=qLeft.remove();
            TreeNode right=qRight.remove(); 
            if ((left==null && right!=null) || (left!=null && right==null)) return false;
            if (left!=null) { 
                if (left.val!=right.val) return false; 
                qLeft.add(left.left); 
                qLeft.add(left.right); 
                qRight.add(right.right); 
                qRight.add(right.left); 
            }
        }
        return true;
    }
    
}

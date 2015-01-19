package question91_100;

import java.util.*;

public class RecoverBST {
	public void recoverTree(TreeNode root) {
		TreeNode[] a= new TreeNode[3];  
		inorder(root, a); 
		if (a[1]!=null) swap(a[1], a[2]); 
	}
	
	public void swap(TreeNode first, TreeNode second) {
		int f = first.val; 
		first.val = second.val; 
		second.val = f; 
	}
	
	public TreeNode[] inorder(TreeNode root, TreeNode[] aa) {
		if (root==null) return aa ; 
		TreeNode[] a = inorder(root.left, aa); 
		if (a[0] != null &&a[0].val>root.val) { // a[0] is prev, a[1] is first, a[2] is second
			if (a[1]==null) a[1] = a[0]; 
			a[2] = root; 
		}
		
		a[0] = root; 
		inorder(root.right, a); 
		return a; 
	}
	
	
	public static void main(String[] args) {
		RecoverBST rbst = new RecoverBST(); 
		TreeNode root = new TreeNode(0); 
		root.left = new TreeNode(1); 
		rbst.recoverTree(root); 
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}    

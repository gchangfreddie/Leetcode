package question.sixty.to.seventy;

import java.util.Stack;

public class FlattenBTToLinkedList {
	public class Solution {
//		public void flatten(TreeNode root) {
//	        if (root==null) return; 
//	        Stack<TreeNode> s = new Stack<TreeNode>(); 
//	        s.push(root); 
//	        TreeNode prev = null; 
//	        while (!s.isEmpty()) {
//	            TreeNode node = s.pop();  
//	            if (node.right!=null) s.push(node.right); 
//	            if (node.left!=null) s.push(node.left); 
//	            if (prev!=null) { 
//	               prev.right = node; 
//	              prev.left = null; // this is very neccesary
//	            }
//	            prev=node;
//	        }
//	}
		
		public void flatten(TreeNode root) {
	        if (root==null) return; 
	        flat(root); 
	    }    
	    
	    public TreeNode flat(TreeNode root) {
	        if (root.left==null && root.right==null) return root; 
	        TreeNode temp = root.right; 
	        if (root.left!=null) {
	            TreeNode leave = flat(root.left); 
	            root.right = root.left; 
	            root.left =null; 
	            leave.right = temp; 
	            if (temp!=null) return flat(temp); 
	            else return leave; 
	        } else {
	            return flat(temp); 
	        }
	    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
}

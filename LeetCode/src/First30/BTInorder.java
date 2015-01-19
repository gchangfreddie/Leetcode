package First30;

import java.util.*;

public class BTInorder {

	public class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) { val = x; }
	}     

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode> (); 
		TreeNode node = root; 
		ArrayList<Integer> al = new ArrayList<Integer>(); 
		while(node != null && !s.isEmpty()) {
			if(node== null) node = s.pop(); 
			if (node.left!= null) {
				s.push(node); 
				node = node.left; 
			} else {
				al.add(node.val); 
				if (node.right== null) {
					node = s.pop(); 
					al.add(node.val); 
				}
				node = node.right;
			}
		}
		return al; 
		

	}
}

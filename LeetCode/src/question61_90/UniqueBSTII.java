package question61_90;

import java.util.ArrayList;

public class UniqueBSTII {
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees(1, n); 
	}	 

	public ArrayList<TreeNode> generateTrees(int start, int n) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>(); 
		if (start>n) { 
			res.add(null); 
		} else if (start==n) {
			res.add(new TreeNode(n)); 
		} else {
			for (int i=start; i<=n; i++) {
				ArrayList<TreeNode> temp1 = generateTrees(start, i-1); 
				ArrayList<TreeNode> temp2 = generateTrees(i+1, n); 

				for (TreeNode left :temp1) 
					for  (TreeNode right : temp2) {
						TreeNode temp = new TreeNode(i); 
						temp.left = left; 
						temp.right = right; 
						res.add(temp); 
					}
			}
		}
		return res; 
	}
	
	public static void main(String[] args) {
		ArrayList<TreeNode> al = new UniqueBSTII().generateTrees(2); 
		for (TreeNode t: al) {
			print(t); 
			System.out.println();
		}
	}
	
	public static void print(TreeNode root) {
		if (root==null ) {
			System.out.print(" # "); 
			return;
		} 
		System.out.print(" " + root.val);
		if (root.left!=null || root.right!=null) {
			print(root.left); 
			print(root.right); 
		}
		
	}
}

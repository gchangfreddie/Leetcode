package Tree;

public class BBT {
	 public boolean isBalanced(TreeNode root) {
		 return isBa(root)==-1 ? false: true;
	 }
	 
	 public int isBa(TreeNode root) {
		 if (root==null) return 0; 
		 int left = isBa(root.left); 
		 int right = isBa(root.right); 
		 if (left==-1 || right==-1) return -1; 
		 if (Math.abs(left-right)>1) return -1;
		 return Math.max(left, right)+1;
	 }
}

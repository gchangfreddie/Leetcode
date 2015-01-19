package question1_30.q10;

public class MaxDepthOfBTree {

	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	

	public int maxDepth(TreeNode root) {
		if (root==null) return 0; 
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1; 
	}
	
	 public boolean isSameTree(TreeNode p, TreeNode q) {
	        if (p==null && q == null) return true; 
	        if (p!=null && q!= null) {
	            return isSameTree(p.left, q.left) &&
	                   isSameTree(p.right, q.right) && (p.val == q.val); 
	        } else return false; 
	        }
}

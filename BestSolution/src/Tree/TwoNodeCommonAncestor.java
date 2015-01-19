package Tree;

public class TwoNodeCommonAncestor {
	public TreeNode twoNodesAncestor(TreeNode root, TreeNode t1, TreeNode t2){
		if (root==null) return null; 
		return foo(root, t1, t2).node; 
	}
	
	public Res foo(TreeNode root, TreeNode t1, TreeNode t2){
		if (root==null) return new Res(false, null); 
		if (root==t1 && root==t2) return new Res(true, root); 
		
		Res left = foo(root.left, t1, t2); 
		if (left.is) return left; 
		Res right = foo(root.right, t1, t2); 
		if (right.is) return right;
		
		if (left.node!=null && right.node!=null) 
			return new Res(true, root); 
		if (root==t1|| root==t2) {
			boolean temp = left.node!=null || right.node!=null ? true : false;
			return new Res(temp, root); 
		} else {
			TreeNode node = left.node==null ? right.node : left.node; 
			return new Res(false, node); 
		}
	}
}

class Res{
	boolean is; 
	TreeNode node; 
	public Res(boolean i, TreeNode t){
		is=i; 
		node=t;
	}
}

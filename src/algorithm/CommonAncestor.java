package algorithm;

public class CommonAncestor {
	public static Integer commonAncestor(TreeNode root, int val1, int val2) {
		// first check whether both nodes are in tree, that will make the following code cleaner and easier
		if (root==null || !cover(root, val1) || !cover(root, val2)) return null; 
		// if one of the val equals root.val, then root is the ancestor of another, return it. 
		if (val1==root.val || val2==root.val) { //base case
			return root.val; 
		} 
		// use 2 boolean to check whether val1 and val2 are in diff sides or same side
		boolean compareV1 = val1<root.val;
		boolean compareV2 = val2<root.val; 
		if (compareV1 != compareV2) return root.val;  // another base case
		// recursive part
		if (compareV1) return commonAncestor(root.left, val1, val2); 
		else return commonAncestor(root.right, val1, val2); 
	}
	
	private static boolean cover(TreeNode root, int val) {
		if (root==null) return false; 
		if (root.val==val) return true; 
		TreeNode childSide = root.val<val ? root.right : root.left; 
		return cover(childSide, val); 
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10); 
		TreeNode node5 = new TreeNode(5); 
		TreeNode node20 = new TreeNode(20); 
		TreeNode node24 = new TreeNode(24); 
		root.left = node5; root.right = node20; 
		node5.left =  new TreeNode(3); node5.right =new TreeNode(7); 
		node20.left = new TreeNode(18); node20.right = node24; 
		node24.left = new TreeNode(22); node24.right = new TreeNode(30); 
		System.out.println(commonAncestor(root,18, 15));
	}
}

class TreeNode{
	int val; 
	TreeNode left, right;
	public TreeNode(int v) {
		val=v; 
	}
}
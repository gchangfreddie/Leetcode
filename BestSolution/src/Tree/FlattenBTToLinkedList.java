package Tree;

public class FlattenBTToLinkedList {
	public static void flatten(TreeNode root) {
        if (root!=null) flat(root); 
    }
    private static TreeNode flat(TreeNode root) {
    	if (root.left==null && root.right==null) return root; 
        if (root.left==null) return flat(root.right);
        TreeNode leaf = flat(root.left); 
        leaf.right=root.right; 
        root.right = root.left; 
        root.left= null; 
        return leaf.right==null ? leaf : flat(leaf.right); 
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(1); 
    	TreeNode node2 = new TreeNode(2); 
    	node2.left = new TreeNode(3); 
    	root.left = node2; 
//    	root.right = new TreeNode(3); 
    	flatten(root); 
    	System.out.println("end");
    }
}

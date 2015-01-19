package Tree;

public class MinDepth {
	public static int minDepth(TreeNode root) {
        if (root==null) return 0;
        return min(root); 
    }
    
    public static int min(TreeNode root){
        if (root==null) return Integer.MAX_VALUE;
        if (root.left==null && root.right==null) return 1; 
        return Math.min(min(root.left), min(root.right))+1;
    }
    
}

package Tree;

public class SumRootToLeafNode {
	public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        return  sum(root, 0); 
    }
    
    public int sum(TreeNode root, int sum){
        if (root.left==null && root.right==null) return sum*10+root.val;
        int res = 0; 
        if (root.left!=null) res+=sum(root.left, sum*10+root.val); 
        if (root.right!=null) res+=sum(root.right, sum*10+root.val); 
        return res;
    }
}

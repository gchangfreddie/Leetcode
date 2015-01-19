package question101_150;

public class BinaryTreeMaxPath {
	public int maxPathSum(TreeNode root) {
        int[] res = maxPathSumRecursive(root); 
        return res[0]; 
    }
	
	public int[] maxPathSumRecursive(TreeNode root){
		int [] res = new int[3]; 
		if (root==null) {
			for (int i=0; i<3; i++) res[i]=Integer.MIN_VALUE;
			return res;
		}
		
		int[] left = maxPathSumRecursive(root.left); 
		int[] right = maxPathSumRecursive(root.right); 
		
		res[1] = Math.max(left[1]>0 ? left[1] + root.val : root.val, left[2]>0 ? left[2] + root.val : root.val);
		res[2] = Math.max(right[1]>0 ? right[1] +root.val : root.val, right[2]>0 ? right[2] + root.val: root.val); 
				res[0] = Math.max(Math.max(left[0], right[0]), Math.max(res[1], res[2])+root.val);
		
		return res; 
	}
	
//	public int maxPathSum(TreeNode root) {
//        if (root==null) return 0; 
//        int[] res = maxPath(root); 
//        return res[0]; 
//    }
    
    public int[] maxPath(TreeNode root){
        int[] res = new int[2];
        if (root==null){
            res[0]=Integer.MIN_VALUE; 
            res[1]=Integer.MIN_VALUE;
        } else{
            int[] left = maxPath(root.left); 
            int[] right = maxPath(root.right); 
            res[1] = Math.max(Math.max(left[1], right[1]), 0) + root.val; 
            int tempMax = Math.max(left[0], right[0]); 
            int part = left[1]>0 ? left[1] : 0; 
            int part1 = right[1]>0 ? right[1] : 0; 
            res[0] = Math.max(tempMax, root.val + part + part1); 
        }
        return res; 
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1); 
//		root.left = new TreeNode(2); 
//		root.right = new TreeNode(3); 
		BinaryTreeMaxPath btmp = new BinaryTreeMaxPath(); 
		System.out.println(btmp.maxPathSum(root));
	}
	
}

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
}     

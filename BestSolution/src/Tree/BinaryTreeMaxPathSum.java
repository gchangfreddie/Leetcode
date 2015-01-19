package Tree;

public class BinaryTreeMaxPathSum {
	public static int maxPathSum(TreeNode root) {
        if (root==null) return 0; 
        return max(root)[0]; 
    }
    
    public static int[] max(TreeNode root){
        int[] res = new int[2];
        if (root==null) {
            res[0]=Integer.MIN_VALUE; 
            res[1]=Integer.MIN_VALUE;
        } else{
            int[] left = max(root.left); 
            int[] right = max(root.right); 
            int path = Math.max(left[1], right[1]); 
            res[1]=path>0? root.val+path : root.val; 
            if (left[1]>0 && right[1]>0) res[0]=root.val+left[1]+right[1];
            else res[0]=res[1]; 
            res[0]=Math.max(Math.max(left[0], right[0]), res[0]);
        }
        return res;
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(-2); 
    	TreeNode node = new TreeNode(1); 
    	root.left = node;
    	System.out.println(maxPathSum(root));
    }
}


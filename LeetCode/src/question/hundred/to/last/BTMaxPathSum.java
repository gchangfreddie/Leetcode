package question.hundred.to.last;

public class BTMaxPathSum {
	public int maxPathSum(TreeNode root) {
        if (root==null) return 0; 
        int[] res = maxPath(root); 
        return res[1]; 
    }
    
    public int[] maxPath(TreeNode root) {
        int[] res = new int[2];
        if (root==null) {
            for (int i=0; i<2; i++) res[i]= Integer.MIN_VALUE; 
        }  else { 
            int[] left = maxPath(root.left);
            int[] right = maxPath(root.right); 
            if (Math.max(left[0], right[0])>0) 
                res[0] = Math.max(left[0], right[0])+root.val; 
            else res[0] = root.val; 
            if (left[0]>0 && right[0]>0) 
            	res[1] = left[0]+right[0]+root.val; 
            else res[1]=res[0]; 
            res[1] = Math.max(Math.max(left[1], right[1]), res[1]); 
        }
        return res; //res[0] is the pathSum, res[1] is the max sum till root
    }
    
    public static void main(String[] args) {
    	BTMaxPathSum b = new BTMaxPathSum(); 
    	TreeNode node = new TreeNode(1); 
    	node.left = new TreeNode(2); 
    	b.maxPathSum(node); 
    }
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

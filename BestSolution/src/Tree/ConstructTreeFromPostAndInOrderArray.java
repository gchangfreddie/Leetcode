package Tree;

public class ConstructTreeFromPostAndInOrderArray {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null || inorder.length==0 || postorder==null || postorder.length==0) return null;
        return constructTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1); 
    }
    
    private TreeNode  constructTree(int[] in, int is, int es, int[] post, int ps, int pe){
        if (ps>pe) return null; 
        TreeNode root = new TreeNode(post[pe]); 
        int i=is; 
        for (; i<=es; i++) {
            if (in[i]==post[pe]) break;
        }
        int distance = i-is; 
        root.left = constructTree(in, is, i-1, post, ps, ps+distance-1); 
        root.right = constructTree(in, i+1, es, post, ps+distance, pe-1); 
        return root; 
    }
}

package Tree;
import java.util.*;
public class ConstructTreeFromPreAndInOrderArray {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null || preorder.length==0 || inorder==null || inorder.length==0) return null; 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i); 
        }
        return constructTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map); 
    }
    private TreeNode constructTree(int[] pre, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer, Integer> map){
        if (ps>pe) return null; 
        TreeNode root = new TreeNode(pre[ps]); 
        int index = map.get(pre[ps]); 
        int distance = index-is; 
        root.left = constructTree(pre, ps+1, ps+distance, inorder, is, index-1, map); 
        root.right = constructTree(pre, ps+distance+1, pe, inorder, index+1, ie, map); 
        return root; 
    }
}

package question.seventy.to.hundred;

import java.util.HashMap;

public class ConvertIntArrayToBST {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null) return null; 
        HashMap<Integer, Integer> inMap = buildMap(inorder); 
        int pl= postorder.length, il= inorder.length; 
        return buildTree(inorder, postorder, 0, il-1, 0, pl-1, inMap); 
    }
    
    public TreeNode buildTree(int[] a, int[] b, int si, int ei, int sp, int ep, HashMap<Integer, Integer> map) {
        if (si>ei || sp>ep) return null; 
        TreeNode root = new TreeNode(b[ep]); 
        int index = map.get(b[ep]); 
        int rootIndex = ep-1-(ei-index); 
        root.left = buildTree(a, b, si, index-1, sp, rootIndex, map); 
        root.right = buildTree(a, b, index+1, ei, rootIndex-1, ep-1, map); 
        return root; 
    }
    
    public HashMap<Integer, Integer> buildMap(int[] a){
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>(); 
        if (a.length==0) return res;
        for (int i=0; i<a.length; i++) {
            res.put(a[i], i); 
        }
        return res; 
    } 
    
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

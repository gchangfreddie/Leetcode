package question.seventy.to.hundred;

import java.util.HashMap;

public class ConstructBTFromPreIn {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = build(inorder); 
		if (preorder==null || preorder.length==0 || inorder==null || inorder.length==0) return null;
		return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, map); 

	}

	public TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int ii, int ie,  HashMap<Integer, Integer> map) {
		if (ps>pe ||  ii>ie) return null; 
		TreeNode root = new TreeNode(preorder[ps]); 
		int index = map.get(preorder[ps]); 
		// use the same amount of nodes to calculate the preorder index 
		root.left = build(preorder, inorder, ps+1, ps+index-ii, ii, index-1, map); 
		root.right = build(preorder, inorder, ps+index-ii+1, pe, index+1, ie, map); 
		return root; 
	}

	private HashMap<Integer, Integer> build(int[] a) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for (int i=0; i<a.length; i++) {
			map.put(a[i], i); 
		}
		return map; 
	}

	public static void main(String[] args) {
		ConstructBTFromPreIn cbt = new ConstructBTFromPreIn(); 
		TreeNode res = cbt.buildTree(new int[]{1, 2,3}, new int[]{1, 2, 3}); 
		System.exit(0);
	}
}


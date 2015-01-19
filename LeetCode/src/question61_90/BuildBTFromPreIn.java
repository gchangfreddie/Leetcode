package question61_90;

import java.util.HashMap;

public class BuildBTFromPreIn {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = build(inorder); 
		HashMap<Integer, Integer> map1 = build(preorder); 
		if (preorder==null || preorder.length==0 || inorder==null || inorder.length==0) return null;
		return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, map, map1); 
		
	}

	public TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int ii, int ie,  HashMap<Integer, Integer> map, HashMap<Integer, Integer> map1) {
	    if (ps>pe ||  ii>ie) return null; 
		TreeNode root = new TreeNode(preorder[ps]); 
		if (ps<pe && ii<ie){
			int index = map.get(preorder[ps]); 
		    int k = (index==ie) ? pe+1 : (index==ii) ? ps+1 :map1.get(inorder[index+1])-1; 
			if (index!=ii) {
				root.left = build(preorder, inorder, ps+1, k-1, ii, index-1, map, map1); 
			}
			if (index!=ie) { 
				root.right = build(preorder, inorder, k, pe, index+1, ie, map, map1);
			}
		}
		return root; 
	}

	private HashMap<Integer, Integer> build(int[] a) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		for (int i=0; i<a.length; i++) {
			map.put(a[i], i); 
		}
		return map; 
	}
	
	public static void main(String[] args){
		BuildBTFromPreIn bb = new BuildBTFromPreIn(); 
		bb.buildTree(new int[]{1,2,3}, new int[]{1,2,3}); 
	}
}

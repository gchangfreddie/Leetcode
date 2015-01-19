package First30;

import java.util.*;
public class PreOrder {
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer> (); 
        if (root==null) return res; 
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        while(root!=null) {
            res.add(root.val); 
            if (root.left!=null) {
                if (root.right!=null) stack.push(root.right); 
                root=root.left; 
            } else if (root.right!=null) {
                root = root.right; 
            } else {
                root = stack.isEmpty() ? null : stack.pop(); 
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3); 
		TreeNode left = new TreeNode(2); 
		TreeNode left1 = new TreeNode(1); 
		root.left=left1;
		root.right=left;
		preorderTraversal(root); 
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

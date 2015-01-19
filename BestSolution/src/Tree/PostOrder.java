package Tree;

import java.util.*;
public class PostOrder {
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer> (); 
        if (root==null) return res; 
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        stack.push(root); 
        TreeNode prev=null; 
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek(); 
            if (prev==null) { // root node
                if (cur.right!=null) {
                    stack.push(cur.right); 
                }
                if (cur.left!=null) {
                    stack.push(cur.left); 
                }
            } else {
                if ((cur.left==null && cur.right==null) || (prev==cur.left || prev==cur.right)) {
                    stack.pop(); 
                    res.add(cur.val); 
                } else {
                	if (cur.right!=null) stack.push(cur.right); 
                	if (cur.left!=null) stack.push(cur.left); 
                }
            }
            prev=cur;
        }
        return res; 
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(2); 
		TreeNode left = new TreeNode(1);  root.left=left;
		TreeNode left1 = new TreeNode(4); left.left=left1;
		TreeNode right = new TreeNode(3);  root.right=right;
		List<Integer> res = postorderTraversal(root); 
		for (Integer i : res) {
			System.out.print(i + "  ");
		}
		System.exit(0);
	}
}

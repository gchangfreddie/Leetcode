package Tree;
import java.util.*;
public class InOrder {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>(); 
		if (root==null) return res;
		Stack<TreeNode> stack = new Stack<TreeNode>(); 
		while(!stack.isEmpty() || root!=null){
			if (root!=null) {
				stack.push(root); 
				root=root.left; 
			} else{
				root= stack.pop(); 
				res.add(root.val); // when a node if pop up from stack, that means we have traverse its left node, so just handle its right
				root=root.right; 
			}
		}
		return res;
	}
	
	public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>(); 
        if (root==null) return res;
        TreeNode prev=null; 
        while(root!=null) {
            if (root.left==null) {
                res.add(root.val); 
                root=root.right;
            } else {
                prev=root.left;
                while (prev.right!=null && prev.right!=root) prev=prev.right;
                if (prev.right==null) {
                    prev.right=root;
                    root=root.left;
                } else{
                    prev.right=null;
                    res.add(root.val); 
                    root=root.right;
                }
            }
        }
        return res;
    }
} 



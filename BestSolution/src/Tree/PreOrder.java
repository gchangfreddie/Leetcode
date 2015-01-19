package Tree;

import java.util.*;

public class PreOrder {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
        if (root==null) return list;
        Stack<TreeNode> stack=new Stack<TreeNode>(); 
        while (root!=null || !stack.isEmpty()) {
            if (root==null) root=stack.pop(); 
            list.add(root.val); 
            if (root.right!=null) stack.push(root.right); 
            root=root.left; 
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

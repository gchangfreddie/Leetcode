package question.sixty.to.seventy;
import java.util.*;

public class ZigzagBT {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); 
		if (root ==null) return res; 
		LinkedList<TreeNode> q1 = new LinkedList<TreeNode>(); 
		LinkedList<TreeNode> q2 = new LinkedList<TreeNode>(); 
		q1.add(root); 
		traverse(res, q1, q2, true); 
		return res; 
	}

	public void traverse(ArrayList<ArrayList<Integer>> res, LinkedList<TreeNode> q1, LinkedList<TreeNode> q2, boolean left ){
		if (q1.isEmpty()) return ; 
		ArrayList<Integer> al = new ArrayList<Integer>(); 
		while (!q1.isEmpty()) {
			TreeNode node = left ? q1.removeLast() : q1.removeFirst();
			al.add(node.val); 
			if (left) {
				q2.addLast(node.left); 
				q2.addLast(node.right); 
			} else {
				q2.addFirst(node.right); 
				q2.addFirst(node.left); 
			}
		}
		res.add(al);
		traverse(res, q2, new LinkedList<TreeNode>(), left ? false :true); 
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}

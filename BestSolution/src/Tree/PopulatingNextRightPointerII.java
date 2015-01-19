package Tree;
import java.util.*;
public class PopulatingNextRightPointerII {
	public void connect(TreeLinkNode root) {
        if (root==null || (root.left==null && root.right==null)) return; 
        Queue<TreeLinkNode> q1= new LinkedList<TreeLinkNode>(); 
        Queue<TreeLinkNode> q2= new LinkedList<TreeLinkNode>(); 
        q1.add(root); 
        while(!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                TreeLinkNode node = q1.poll(); 
                node.next = q1.isEmpty() ? null : q1.peek(); 
                if (node.left!=null) q2.add(node.left); 
                if (node.right!=null) q2.add(node.right); 
            }
            q1=new LinkedList<TreeLinkNode>(q2); 
            q2.clear(); 
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

package Tree;
import java.util.*;
public class PopulatingNextRightPoint {
	public void connect(TreeLinkNode root) {
        if (root==null) return ; 
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>(); 
        q.add(root); 
        while(!q.isEmpty()){
            TreeLinkNode node = q.poll(); 
            if (node.left!=null) {
                node.left.next = node.right; 
                node.right.next = node.next==null ? null : node.next.left; 
                q.add(node.left); 
                q.add(node.right); 
            }    
        }
    }
}

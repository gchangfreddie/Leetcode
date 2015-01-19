package question1_30.q10;

import java.util.*;

public class PopulatingNextRightPointersII {
//	public void connect(TreeLinkNode root) {
//		if (root==null) return; 
//        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>(); 
//        queue.add(root); 
//        Queue<TreeLinkNode> list = new LinkedList<TreeLinkNode>(); 
//        while (!queue.isEmpty()){
//            TreeLinkNode prev = queue.remove(); 
//            prev.next = queue.isEmpty() ? null : queue.peek(); 
//            if (prev.left!=null) list.add(prev.left); 
//            if (prev.right!=null) list.add(prev.right); 
//            if (queue.isEmpty()) {
//                queue = new LinkedList<TreeLinkNode>(list); 
//                list.clear();
//            }    
//        }
//    }
	
	public static void connect(TreeLinkNode root) {
        if (root==null) return; 
        TreeLinkNode cur=root, first = root;
        root.next = null; 
        while (first.left!=null) {
        	first = first.left; 
        	cur = first;
	        while(cur!=null) {
	            if (cur.left!=null) {
	                cur.left.next = cur.right; 
	                cur.right.next = cur.next == null ? null : cur.next.left;
	            }
	            cur= cur.next == null ? null : cur.next;
	        }
        }
    }
	
	public static void main(String[] args){
		TreeLinkNode n0=new TreeLinkNode(0); 
		TreeLinkNode n1=new TreeLinkNode(1); 
		TreeLinkNode n2=new TreeLinkNode(2); 
		TreeLinkNode n3=new TreeLinkNode(3); n0.left=n1; n1.left=n3;
		TreeLinkNode n4=new TreeLinkNode(4); n0.right=n2; n1.right=n4;
		TreeLinkNode n5=new TreeLinkNode(5); 
		TreeLinkNode n6=new TreeLinkNode(6); n2.left=n5; n2.right=n6;
		connect(n0);
		System.exit(0);
	}
}

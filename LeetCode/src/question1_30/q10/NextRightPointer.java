package question1_30.q10;

public class NextRightPointer {

	public void connect(TreeLinkNode root) {
		if (root == null) return ;
		TreeLinkNode aux = root; 
		TreeLinkNode layP;
		aux.next = null; 
		while(aux!=null) {
			if (aux.left == null) break; 
			layP = aux; 
			while (layP!=null) {
				layP.left.next = layP.right;
				layP.right.next = (layP.next == null) ? null : layP.next.left;
				layP = layP.next; 
			}
			aux = aux.left; 
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}
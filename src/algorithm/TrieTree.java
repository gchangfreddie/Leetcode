package algorithm;

/**
 * @author Grace Chang (gracechang007@gmail.com)
 * 
 * This class is to implement a tri-nary tree
 * A tri-nary tree is much like a binary tree but with three child nodes for each parent insted of two
 * 		Left node being values less than the parent
 * 		Right node being values greater than the parent
 * 		Middle nodes values equal to the parent
 */
public class TrieTree<V extends Comparable<V>> {

	private TrieNode root; 

	public TrieTree() {
		root=null; 
	}
	
	/**
	 * @author Grace
	 * This class stands for each node in TrieTree
	 */
	class TrieNode{
		V val; 
		TrieNode left, middle, right; 

		public TrieNode(V val){
			this.val = val; 
		}
	}
	
	/**
	 * insert a node in Trie tree
	 * @param v value for inserted node
	 * @return root of Trie tree
	 */
	public TrieNode insert(V v) {
		root=insert(root, v); 
		return root;
	}

	private TrieNode insert(TrieNode root, V v){
		if (root==null) {
			return new TrieNode(v); 
		} else {
			if (root.val.compareTo(v)==0) root.middle = insert(root.middle, v); 
			else if (root.val.compareTo(v)<0) root.right = insert(root.right, v); 
			else root.left = insert(root.left, v); 
		}
		return root; 
	}

	/**
	 * delete a node in Trie Tree
	 * @param v value of deleted node
	 * @return root of Trie tree
	 */
	public TrieNode delete(V v){
		root= delete(root, v); 
		return root; 
	}

	private TrieNode delete(TrieNode root, V v){
		if (root==null) return null; 
		// move down to right branch
		if (root.val.compareTo(v)<0) {
			root.right = delete(root.right, v); 
			return root; 
		} 
		// move down to left branch
		if (root.val.compareTo(v)>0) {
			root.left =delete(root.left, v); 
			return root; 
		}
		// try to delete the most bottom node
		if (root.middle!=null) {
			root.middle = delete(root.middle, v); 
			return root; 
		} 
		// find node and node is leaf
		if (root.left==null && root.right==null) {
			return null; 
		}
		// find root but root has one child, replace root with root's child
		if (root.right==null || root.left==null) {
			return root.right==null ? root.left : root.right; 
		}
		// root has both children, so find root's previous node
		TrieNode parent = root.left, child = parent.right; 
		if (child==null) { // directly use root.left subsitute root.
			parent.right = root.right; 
			return parent;
		}
		else {
			// find the most right node in root's left branch, replace root with this node, this node 
			// has no right node, move this node's left branch to its parent's right
			while(child.right!=null) {
				parent=child; 
				child=child.right;
			}
			parent.right=child.left; 
			child.left=root.left; 
			child.right=root.right;
			return child; 
		}
	}

	/**
	 * in-order traversal the Tri-nary Tree
	 * @param root
	 */
	public void print(TrieNode root) {
		if (root==null) return ;
		print(root.left); 
		print(root.middle); 
		System.out.print(root.val + " ");
		print(root.right);
	}
	
	/**
	 * Do test for Tri-nary
	 * @param args
	 */
	public static void main(String[] args){
		TrieTree<Integer> ttc = new TrieTree<Integer>(); 
		int[] array = new int[]{5, 4, 9, 5, 7, 2, 2};
		for (int i : array){
			ttc.insert(i); 
		}
		ttc.print(ttc.root); 
		System.out.println();
		ttc.delete(5); 
		ttc.delete(5); 
		ttc.print(ttc.root); 
		System.out.println();
		ttc.insert(5); 
		ttc.print(ttc.root);
	}
}


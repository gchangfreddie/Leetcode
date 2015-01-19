package question61_90;

public class ConvertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head==null) return null; 
		return sort(head); 
	}

	public TreeNode sort(ListNode head) {
		if (head.next==null) return new TreeNode(head.val); 
		ListNode s=head, f=head, prev=null; 
		while(f!=null && f.next!=null) {
			f=f.next.next;
			prev=s;
			s=s.next; 
		}
		TreeNode root = new TreeNode(s.val); 
		prev.next=null; 
		root.left = sort(head); 
		root.right = s.next==null? null : sort(s.next); 
		return root; 
	}

	public TreeNode sortedListToBST1(ListNode head) {
		if (head==null) return null; 
		ListNode h=head; 
		int len = 0; 
		while (h!=null) {
			len++; h=h.next;
		}
		return sort(head, 1, len).tree; 
	}

	public class Elem {
		ListNode list;
		TreeNode tree;
		public Elem(ListNode l, TreeNode t) {
			list=l; 
			tree=t;
		}
	}

	public Elem sort(ListNode head, int s, int e) {
		if (s>e) return new Elem(head, null);
		int m = s+(e-s)/2;
		Elem left = sort(head, s, m-1); 
		ListNode mid = left.list; 
		TreeNode root = new TreeNode(mid.val); 
		root.left=left.tree;
		Elem right = sort(mid.next, m+1, e); 
		root.right = right.tree; 
		return new Elem(right.list, root); // right.list is the next node 
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1); 
		ListNode three = new ListNode(3); 
		one.next = three; 
		ConvertSortedListToBST cs = new ConvertSortedListToBST(); 
		cs.sortedListToBST(one); 

	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


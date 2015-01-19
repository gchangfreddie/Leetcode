package leetCode.LinkedList;

public class Add2Number {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1==null || l2==null) return l1==null ? l2 : l1; 
		ListNode res = new ListNode(0), prev=res;
		int c =0; 
		while (l1!=null || l2!=null || c!=0) {
			int v1 = l1!=null ? l1.val : 0; 
			int v2 = l2!=null ? l2.val : 0; 
			int sum = v1+v2+c; 
			ListNode n = new ListNode(sum%10); 
			prev.next = n; 
			prev=n; 
			c=sum/10;
			l1=l1!=null ? l1.next : null; 
			l2=l2!=null ? l2.next : null; 
		}
		return res.next; 
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

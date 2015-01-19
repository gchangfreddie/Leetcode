package question101_150;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head==null || head.next == null) return head; 
		int len = 1; 
		ListNode temp = head; 
		while (temp.next!=null) {
			len++; 
			temp=temp.next; 
		}
		return sort(head, len); 
	}
	
	public ListNode sort(ListNode head, int len) {
		//base case
		if (head==null || head.next == null) return head;
		if (len==1 ) {
			head.next = null; 
			return head; 
		}
		if (len<=2 ) {
			if (head.val > head.next.val) {
				return swap(head, head.next); 
			} else {
				head.next.next=null; 
				return head; 
			}
		}
		ListNode temp = head; 
		for (int i=0; i<len/2; i++) {
			temp= temp.next; 
		}
		ListNode node1=sort(head, len/2);
		ListNode node2=sort(temp, len-len/2); 
		return merge(node1, node2); 
	}
	
	private ListNode merge(ListNode node1, ListNode node2) {
		if (node1==null || node2 == null) return (node1==null)? node2 : node1; 
		ListNode res0 = new ListNode(0), res=res0;  
		
		while (node1!=null && node2!=null) {
			if (node1.val < node2.val) {
				res.next = node1; 
				node1 = node1.next;
			}
			else {
				res.next = node2;
				node2 = node2.next; 
			}
			res = res.next; 
		}
		ListNode temp = null; 
		if (node1==null && node2!=null) {
			 temp = node2; 
		} else if (node2==null && node1!=null){
			temp = node1; 
		}
		while (temp!=null) {
			res.next=temp; 
			res = res.next; 
			temp = temp.next; 
		}
		return res0.next; 
	}
	
	private ListNode swap(ListNode h, ListNode n) {
		h.next = null; 
		n.next = h; 
		return n; 
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode head = new ListNode(5); 
		ListNode node = new ListNode(2); 
		ListNode node2 = new ListNode(4); node1.next = node2;  
		ListNode node3 = new ListNode(1); node2.next = node3; 
		ListNode node4 = new ListNode(0); node3.next = node4; 
		node.next = node1; 
		head.next = node; 
		ListNode res = head; 
		while(res!=null) {
			System.out.print(" " + res.val);
			res=res.next; 
		}
		SortList sl = new SortList(); 
		res = sl.sortList(head);
		while(res!=null) {
			System.out.print(" " + res.val);
			res=res.next; 
		}
	}

}


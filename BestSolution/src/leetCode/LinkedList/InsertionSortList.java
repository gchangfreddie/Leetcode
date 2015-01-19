package leetCode.LinkedList;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head==null || head.next ==null) return head;
		ListNode aux = new ListNode(0); 
		aux.next=head;
		while (head.next!=null) {
			if (head.next.val>=head.val) {
				head=head.next;
			} else {
				ListNode prev=aux; 
				ListNode cur=head.next; 
				head.next = cur.next;
				while (prev.next.val<cur.val) prev=prev.next;
				cur.next = prev.next;
				prev.next=cur;
			}
		}
		return aux.next;
	}
}

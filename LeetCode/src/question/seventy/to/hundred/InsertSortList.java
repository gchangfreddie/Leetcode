package question.seventy.to.hundred;

public class InsertSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head==null || head.next==null) return head; 
		ListNode pre = new ListNode(0); 
		pre.next = head; 
		while(head!=null) {
			ListNode node = head.next; 
			if (node==null) break; 
			if (node.val < head.val) {
				head.next = node.next; 
				ListNode temp = pre.next;
				ListNode tempPrev = pre; 
				while(temp.val<node.val) { tempPrev =temp; temp = temp.next; }
				node.next = temp ; 
				tempPrev.next = node; 
			} else {
				head = head.next; 
			}
		}
		return pre.next; 
	}

	public static void main(String[] args){
		ListNode head = new ListNode(9); 
		ReverseLinkedList rll = new ReverseLinkedList(); 
		ListNode node = head; 
		for (int i=8; i>4; i--) {
			rll.addNode(node, i); 
			node = node.next;
		}
		InsertSortList is = new InsertSortList(); 
		is.print(head);
		head = is.insertionSortList(head); 
		is.print(head);
	}
	
	public void print(ListNode head) {
		ListNode r = head; 
		while (r!=null) {
			System.out.print(r.val+ " ->");
			r=r.next; 
		}
		System.out.println();
	}
}

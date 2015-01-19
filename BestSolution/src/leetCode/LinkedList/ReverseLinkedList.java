package leetCode.LinkedList;

public class ReverseLinkedList {
	public ListNode reverse(ListNode head){
		if (head==null || head.next==null) return head;
		ListNode aux = new ListNode(0), prev=aux;
		aux.next=head;
		while(head.next!=null) {
			ListNode temp = prev.next;
			prev.next=head.next; 
			head.next=head.next.next;
			prev.next.next=temp;
		}
		return aux.next; 
	}
	
	public ListNode reverseRecursive(ListNode head){
		if (head==null) return null; 
		if (head.next==null) return head ;//base case, return the tail, it will be head for the new list
		ListNode cur = head.next; // it will be the tail for the returned list
		ListNode res = reverseRecursive(head.next); 
		cur.next=head;
		head.next=null; // it is import, otherwise a loop happened
		return res;
	}
	
	
	public static void main(String[] args){
		ListNode head = new ListNode(1); 
		ReverseLinkedList rll = new ReverseLinkedList(); 
		ListNode node = head; 
		for (int i=2; i<14; i++) {
			rll.addNode(node, i); 
			node = node.next;
		}
		rll.print(head); 
		head = rll.reverseRecursive(head); 
		rll.print(head); 
	}
	

	private void print(ListNode head) {
		ListNode r = head; 
		while (r!=null) {
			System.out.print(r.val+ " ->");
			r=r.next; 
		}
		System.out.println();
	}
	
	public void addNode(ListNode head, int v) {
		if (head==null) return ; 
		head.next = new ListNode(v); 
	}
}

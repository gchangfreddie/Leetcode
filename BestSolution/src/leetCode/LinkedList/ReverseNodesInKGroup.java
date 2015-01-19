package leetCode.LinkedList;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode aux = new ListNode(0), prev=aux; 
		prev.next=head;
		while(head!=null) {
			ListNode s = head, f=head; 
			int i=0; 
			while (i<k-1 && f!=null) { f=f.next; i++; }
			if (f==null) break;
			head = f.next; 
			prev.next=f;
			prev=s;
			while (s!=f){
				ListNode temp = s.next; 
				s.next=f.next; 
				f.next=s; 
				s=temp; 
			}
		}
		return aux.next;
	}
}

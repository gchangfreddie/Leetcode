package question.seventy.to.hundred;

public class RemoveDupFromSortList {
	public static ListNode deleteDuplicates(ListNode head) {
        ListNode aux = new ListNode(0); 
        aux.next = head;
        ListNode prev = aux;
        while(head!=null) {
            if (head.next!=null && head.next.val==head.val) {
                while(head.next!=null && head.next.val==head.val) head=head.next; 
                prev.next = head.next; 
            } else {
                prev=prev.next; 
            }    
            head=head.next;
        }
        return aux.next; 
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1); 
		ReverseLinkedList rll = new ReverseLinkedList(); 
		ListNode node = head; 
		for (int i=2; i<3; i++) {
			rll.addNode(node, i); 
			node = node.next;
		}
		rll.print(head); 
		
		head = deleteDuplicates(head); 
		rll.print(head);
		System.exit(0);
	}
}

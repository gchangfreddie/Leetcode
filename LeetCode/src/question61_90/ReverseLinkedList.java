package question61_90;

public class ReverseLinkedList {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n) return head; 
        ListNode aux = new ListNode(0); 
        aux.next = head;
        ListNode ent = aux; 
        for (int i=0; i<m-1; i++){
            head=head.next; 
            ent=ent.next; 
        }
        ListNode prev = head; 
        head = head.next; 
        for (int i=0; i<n-m; i++) {
            prev.next = head.next; 
            head.next = ent.next;
            ent.next = head; 
            head=prev.next; 
        }
        return aux.next; 
    }
    
	public static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val + " -> ");
			head=head.next;
		}
		System.out.println("null");
	}
	
    public static void main(String[] args) {
    	ReverseLinkedList rll = new ReverseLinkedList(); 
    	ListNode head = new ListNode(1);
    	ListNode node = new ListNode(2);
    	head.next = node;
    	node.next = new ListNode(3); 
    	print(head); 
    	print(rll.reverseBetween(head, 1, 3)); 
    }
}


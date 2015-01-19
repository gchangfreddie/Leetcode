package question.seventy.to.hundred;

public class ReverseNodesInK {
	public static ListNode reverseKGroup1(ListNode head, int k) {
        if (head==null || head.next == null) return head; 
        ListNode prev = new ListNode(0) ; 
        ListNode res = prev; 
        prev.next = head; 
        while(head!=null && head.next!=null) {
            int i=1; 
            if (!test(head, k)) break;
            while(i<k && head.next!=null) {
                ListNode h = prev.next; 
                prev.next = head.next;
                ListNode next = head.next.next; 
                head.next.next = h;
                head.next = next ;
                i++; 
            }
            prev = head; 
            head = head.next; 
        }
        return res.next; 
    }
	
	public static boolean test(ListNode head, int k) {
        int i=1; 
        while (i<k) {
            i++; 
            head = head.next; 
            if (head==null) return false;
        }
        return true; 
    }
	
	public static void print(ListNode head) {
		ListNode r = head; 
		while (r!=null) {
			System.out.print(r.val+ " ->");
			r=r.next; 
		}
		System.out.println();
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
	       ListNode aux = new ListNode(0), prev=aux; 
	       prev.next=head;
	       boolean set=false;
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
	
	public static void main(String[] args){
		ListNode head = new ListNode(1); 
		ReverseLinkedList rll = new ReverseLinkedList(); 
		ListNode node = head; 
		for (int i=2; i<5; i++) {
			rll.addNode(node, i); 
			node = node.next;
		}
		print(head); 
		
		head = reverseKGroup(head, 2); 
		print(head); 
	}
}

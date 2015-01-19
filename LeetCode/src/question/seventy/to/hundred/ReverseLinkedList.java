package question.seventy.to.hundred;

public class ReverseLinkedList {

	public void addNode(ListNode head, int v) {
		if (head==null) return ; 
		head.next = new ListNode(v); 
	}
	
	public void print(ListNode head) {
		ListNode r = head; 
		while (r!=null) {
			System.out.print(r.val+ " ->");
			r=r.next; 
		}
		System.out.println();
	}
	
	public ListNode recursive(ListNode node, ListNode prev) {
		if (node==null) return null;
		if (node.next==null) {
			node.next=prev;
			return node;
		}
		ListNode temp = recursive(node.next, node); 
		node.next = prev; 
		return temp; 
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head==null || head.next ==null || m==n) return head; 
		int i=1; 
		ListNode res = new ListNode(0);
		res.next = head;
		head = res; 
		while (i<m && head!=null) {
			head = head.next;
			i++; 
		}
		if (head != null && head.next!=null) {
			ListNode mNode=head.next; 
			ListNode nNode = mNode.next; 
			while(mNode!=null && nNode!=null) {
				mNode.next = nNode.next;
				nNode.next = head.next; 
				head.next = nNode; 
				nNode = mNode.next; 
				if(++i==n) break; 
			}
		}
		return res.next; 
    }
	
	public static void main(String[] args){
		System.out.println(stringConcat("I can", "get Cisco offer"));
		ListNode head = new ListNode(1); 
		ReverseLinkedList rll = new ReverseLinkedList(); 
		ListNode node = head; 
		for (int i=2; i<14; i++) {
			rll.addNode(node, i); 
			node = node.next;
		}
		rll.print(head); 
		head = rll.reverse(head); 
		rll.print(head); 
		
//		head = rll.recursive(head, null); 
//		rll.print(head);
		
//		head = rll.interative(head); 
//		rll.print(head);
		System.exit(0);
	}

	private ListNode interative(ListNode head) {
		if (head==null || head.next == null) return head; 
		// for 1st and 2nd node, we need do special handle 
		ListNode prev = head; 
		head = head.next; 
		prev.next=null; 
		ListNode temp = head.next; 
		head.next = prev; 
		prev = head;
		head = temp; 
		
		//from the 3rd node
		while (head!=null) {
			temp = head.next; 
			head.next = prev; 
			prev = head; 
			head = temp; 
		}
		return prev;
	}
	
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
	
	public static String stringConcat(String s1, String s2){
		String res = s1+s2; 
		return res; 
	}
}

class ListNode {
	int val; 
	ListNode next; 
	public ListNode(int v){
		val=v; 
		next =null; 
	}
}

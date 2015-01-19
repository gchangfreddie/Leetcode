package leetCode.LinkedList;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null) return head;
        ListNode aux=new ListNode(0), prev=aux; 
        aux.next =head;
        int i=1;
        while (i<m && head!=null) {
            prev=head;
            head=head.next; i++; 
        }
        while (i<n) {
            ListNode temp = prev.next; 
            prev.next = head.next; 
            head.next = prev.next.next; 
            prev.next.next = temp; 
            i++; 
        }
        return aux.next; 
    }
}

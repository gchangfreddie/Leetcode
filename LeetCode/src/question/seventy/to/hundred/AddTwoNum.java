package question.seventy.to.hundred;

public class AddTwoNum {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1==null && l2==null) return null; 
		if (l1==null || l2==null) return (l1==null) ? l2 :l1; 
		ListNode res = new ListNode(0); 
		ListNode running = res; 
		int carry=0; 
		while (l1!=null && l2!=null) {
			running.next = new ListNode(0);
			running = running.next; 
			int sum =  l1.val+l2.val+carry; 
			if (sum>9) carry =1;
			else carry = 0; 
			running.val = sum%10; 
			l1=l1.next; 
			l2=l2.next; 
		}
		while (l1!=null || l2!=null) {
			running.next = new ListNode(0); 
			running = running.next; 
			running.val = (l1!=null) ? l1.val +carry : l2.val+carry; 
			carry=0; 
			if (l1!=null) l1 = l1.next; 
			else l2=l2.next; 
		} 
		return res.next; 
	}
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1); 
		head1.next = new ListNode(8); 
//		head1.next.next = new ListNode(3); 
		ListNode head2 = new ListNode(0);
//		head2.next = new ListNode(6); 
//		head2.next.next = new ListNode(4); 
		ListNode res = addTwoNumbers(head1, head2); 
		
		System.exit(0);
	}
}

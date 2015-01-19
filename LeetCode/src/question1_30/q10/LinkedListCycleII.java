package question1_30.q10;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head==null) return null;
        ListNode slow = head, fast = head; 
        do {
            slow = slow.next; 
            if (fast == null || fast.next == null) return null; 
            fast = fast.next.next; 
        } while (slow != fast);
        ListNode res = head; 
        while(res!=slow) {
            res=res.next; 
            slow = slow.next; 
        }
        return res; 
    }
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}

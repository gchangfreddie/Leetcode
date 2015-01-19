package question.sixty.to.seventy;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head==null || head.next==null) return head; 
		ListNode h = new ListNode(0); 
		h.next = head; 
		ListNode lastLess = h, firstEG = h, lastEG = h, running = head; 
		while(running!=null){
			ListNode next = running.next; 
			if (running.val<x) {
				lastLess.next = running; 
				lastLess = running; 
			} else{
				if (firstEG==h) {
					firstEG=running; 
					lastEG=running; 
				} else {
					lastEG.next = running; 
					lastEG=running; 
				}
			}
			running = next; 
		}
		lastEG.next = (lastEG==h) ? lastEG.next : null ; 
		lastLess.next = (firstEG == h) ? null : firstEG; 
		return h.next; 
	}

	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}

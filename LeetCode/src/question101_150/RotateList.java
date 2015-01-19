package question101_150;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		int len = findLen(head);
        if (len!=0 && len<=n) n = n%len; 
        if (head==null||n==0 || len==1) return head; 
    	ListNode s = head, f =head; 
    	int i=0; 
    	while (i<n && f!=null) {
           f=f.next; i++;
        }
        while (f.next !=null) {
           f=f.next; 
           s=s.next; 
        }
        ListNode res = s.next; 
        s.next = null; 
        f.next = head; 
        return res; 
    }
	
	public int findLen(ListNode head) {
		int res = 0; 
		while (head!=null) {
			head=head.next; 
			res++; 
		}
		return res; 
	}
	
	 public ListNode swapPairs(ListNode head) {
	        if (head==null || head.next == null) return head; 
	        ListNode pre = new ListNode(0); 
	        pre.next = head; 
	        ListNode p = pre, node = head;  
	        while(node!=null && node.next!=null) {
	            p.next=node.next; 
	            node.next = node.next.next; 
	            p.next.next = node;
	            p = node; 
	            node = node.next; 
	        }
	        return pre.next; 
	    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(1); 
		ListNode node = new ListNode(2); 
		head.next = node; 
		RotateList rl = new RotateList(); 
		rl.rotateRight(head, 2); 
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
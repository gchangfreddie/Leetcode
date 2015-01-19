package question101_150;

import java.util.HashMap;
import java.util.Map;

public class RecoderList {
	public void reorderList(ListNode head) {
		if (head==null || head.next==null || head.next.next==null) return ;
		HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>(); 
		ListNode end = head.next, prev = head;
		while(end.next!=null) {
			map.put(end, prev); 
			end = end.next; 
			prev = prev.next; 
		}
		map.put(end, prev); 
		for (ListNode node1 : map.keySet()) {
			System.out.println(node1.val + " prev is " + map.get(node1).val);
		}
		ListNode h = head; 
		reorder(h, map, end); 
	}
	
	public void reorder(ListNode h, HashMap<ListNode, ListNode> map, ListNode end) { 
		if (h==end || h.next == end) {
			end.next = null; 
			return; 
		}
		end.next = h.next; 
		h.next = end; 
		reorder(end.next, map, map.get(end)); 
	}
	
	public static void main(String[] args) {
		RecoderList rl = new RecoderList(); 
		ListNode node1 = new ListNode(3);
		ListNode head = new ListNode(5); 
		ListNode node = new ListNode(2); 
		ListNode node2 = new ListNode(4); node1.next = node2;  
		ListNode node3 = new ListNode(1); node2.next = node3; 
		ListNode node4 = new ListNode(0); node3.next = node4; 
		node.next = node1; 
		head.next = node; 
		print(head);
		System.out.println();
		rl.reorderList(head); 
		print(head); 
	}

	private static void print(ListNode head) {
		ListNode temp = head; 
		while (temp!=null) {
			System.out.print("-> " + temp.val);
			temp= temp.next; 
		}
	}
}

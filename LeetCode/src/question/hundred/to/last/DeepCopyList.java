package question.hundred.to.last;

import java.util.HashMap;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}

public class DeepCopyList {

	public static void main(String[] args) {
		DeepCopyList dcl = new DeepCopyList(); 
		RandomListNode head = new RandomListNode(0);
		RandomListNode next = new RandomListNode(1); 
		head.next = next; 
		head.random = next; 
		next.next = null; 
		next.random = head; 
		RandomListNode res = dcl.copyRandomList1(head); 
		System.exit(0); 
	}
	
	public RandomListNode copyRandomList1(RandomListNode head) {
        if (head==null) return null;
        RandomListNode h = head;
        while(h!=null) {
            RandomListNode newNode = new RandomListNode(h.label); 
            newNode.next = h.next; 
            h.next=newNode; 
            h=newNode.next; 
        }
        h=head; 
        RandomListNode res = new RandomListNode(0), prev=h.next;
        res.next=prev; 
        while (h!=null && h.random!=null) {
            prev.random = h.random.next; 
            h.next=prev.next; 
            h=h.next;
            prev.next= h==null ? null : h.next;
            prev=prev.next;
        }
        return res.next; 
    }
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        RandomListNode h = head;
        while(h!=null) {
            RandomListNode temp = new RandomListNode(h.label); 
            temp.next = h.next; 
            h.next = temp; 
            h=temp.next;
        }
        h = head; 
        while(h!=null) {
            if (h.random!=null)
                h.next.random = h.random.next;
            h = h.next.next; 
        }
        
        h = head; 
        RandomListNode res = head.next, prev = res; 
        while (h!=null) {
            h.next = prev.next;
            h = h.next; 
            if (h!=null) prev.next = h.next; 
            else break; 
            prev = prev.next; 
        }
        return res; 
        // RandomListNode res = new RandomListNode(head.label); 
        // HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>(); 
        // map.put(head, res); 
        // RandomListNode h = head, prev = res;  
        // head = head.next; 
        // while (head!=null) {
        //     RandomListNode temp = new RandomListNode(head.label); 
        //     map.put(head, temp); 
        //     prev.next = temp; 
        //     prev = temp;
        //     head = head.next;
        // }
        
        // head = h; 
        // prev = res; 
        // while(h!=null) {
        //     prev.random = map.get(h.random); 
        //     prev = prev.next;
        //     h = h.next;
        // }
        // return res;
	}
	
}

package question91_100;

import java.util.*;

public class MergeKSorted {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists==null || lists.size() == 0) return null; 
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
			public int compare(ListNode a, ListNode b) {
				return a.val>b.val ? 1 : a.val==b.val ? 0 : -1; 
			}
		}); 
		for (ListNode node : lists) {
			if (node!=null ) q.add(node); 
		}
		ListNode res = new ListNode(0); 
		ListNode running = res; 
		while (!q.isEmpty()) {
			ListNode n = q.poll(); 
			running.next = n; 
			if (n.next!=null ) q.add(n.next); 
			running = running.next; 
		}
		return res.next; 
	}
	
	public ListNode mergeKLists1(List<ListNode> lists) {
        if (lists.size()==0) return null; 
        return merge(lists, 0, lists.size()-1); 
    }
    
    public ListNode merge(List<ListNode> list, int s, int e){
        if (s==e) return list.get(s); 
        if (e==s+1) {
            return merge(list.get(s), list.get(e)); 
        }
        int m = s+(e-s)/2; 
        return merge(merge(list, s, m), merge(list, m+1, e)); 
    }
    
    public ListNode merge(ListNode n1, ListNode n2){
        if (n1==null || n2==null) return (n1==null) ? n2 : n1;
        ListNode res = new ListNode(0); 
        ListNode run = res; 
        while(n1!=null && n2!=null){
            if (n1.val<n2.val) {
                run.next = n1;
                n1=n1.next;
            } else {
                run.next = n2; 
                n2 = n2.next; 
            }
            run = run.next; 
        }
        run.next = (n1!=null) ? n1 : n2;
        return res.next; 
    }
	
	public static void main(String[] args) {
		int a =11,  b=-0; 
		System.out.println(a^b);
		MergeKSorted m = new MergeKSorted(); 
		List<ListNode> list = new ArrayList<ListNode>(); 
		list.add(null);
		m.mergeKLists(list); 
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}
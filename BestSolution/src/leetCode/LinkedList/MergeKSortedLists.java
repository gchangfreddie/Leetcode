package leetCode.LinkedList;

import java.util.*;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size()==0) return null; 
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val-l2.val; 
            }
        });
        for (ListNode n : lists){
            if (n!=null) q.add(n); 
        }     
        ListNode res = new ListNode(0), prev=res;
        while (!q.isEmpty()){
            prev.next = q.remove(); 
            prev=prev.next; 
            if (prev.next!=null) q.add(prev.next); 
        }
        return res.next; 
    }
}

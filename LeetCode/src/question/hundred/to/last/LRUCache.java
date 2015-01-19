package question.hundred.to.last;

import java.util.*;

public class LRUCache {
	int capacity;
	LRUProxy head, end; 
	HashMap<Integer, LRUProxy> cache;

	public LRUCache(int capacity) {
		this.capacity = capacity; 
		cache = new HashMap<Integer, LRUProxy>(); 
		head=null;
		end=null; 
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			LRUProxy result = cache.get(key); 
			if (result!=head) {
				moveTop(result); 
			}
			return result.value; 
		}
		return -1; 
	}

	public void set(int key, int value) {
		if (!cache.containsKey(key)) {
			if (cache.size()==capacity) {
				cache.remove(end.key); 
				deleteLast(); 
			}
			LRUProxy elem = new LRUProxy(key, value); 
			cache.put(key, elem); 
			elem.prev=end;
			end=elem;
			moveTop(elem); 
		} else {
			LRUProxy elem = cache.get(key); 
			elem.value = value; 
			if (elem!=head) {
				moveTop(elem);
			}
		} 
	}

	public void deleteLast() {
		if (head==end) {
			head=null; 
			end=null; 
		} else {
			end.prev.next = null; 
			end=end.prev; 
		}
	}

	public void moveTop(LRUProxy elem) {
		if (head==null) {
			head = elem; 
			end = elem;
		} else {
			elem.prev.next=elem.next; 
			if (elem!=end) elem.next.prev=elem.prev; 
			else end=elem.prev; 
			elem.prev=null; 
			elem.next = head;
			head.prev=elem; 
			head = elem; 
		}
	} 

	public class LRUProxy {
		int key; 
		int value; 
		LRUProxy next, prev; 

		public LRUProxy(int k, int v) {
			key = k;
			value = v; 
			next=null; 
			prev=null; 
		}
	}    

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(3); 
		//    	lru.set(2,1); 
		//    	System.out.println(lru.get(2)); 
		//    	lru.set(3,2); 
		//    	lru.get(2); 
		//    	lru.get(3); 
		lru.set(1,1); 
		lru.set(2,2); 
		lru.set(3,3); lru.set(4,4);
		System.out.println(lru.get(4) + "  " +  lru.get(3)+ "  " + lru.get(2) + "  " + lru.get(1)); 
		lru.set(5,5);
		System.out.println(lru.get(1) + "  " + lru.get(2)+ "  " + lru.get(3));
		System.out.println(lru.get(4) + "  " + lru.get(5));
		//    	4,3,2,-1, -1,2,3, -1,5

	}
}

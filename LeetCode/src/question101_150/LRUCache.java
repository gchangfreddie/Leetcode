package question101_150;

import java.util.*;

public class LRUCache {
	int capacity; 
	int count; 
	HashMap<Integer, CacheObjectProxy> memberMap; 
	CacheObjectProxy head; 
	CacheObjectProxy tail; 

	class CacheObjectProxy{
		private Integer key; 
		private Integer value; 
		public CacheObjectProxy prev; 
		public CacheObjectProxy next; 
		
		public CacheObjectProxy(int a, int b) {
			key = a; 
			value = b; 
			prev = null; 
			next = null; 
		}
	}
	
	public LRUCache(int capacity) {
		this.capacity = capacity; 
		count=0; 
		memberMap = new HashMap<Integer, CacheObjectProxy>(); 
		head = null; 
		tail = null; 
	}

	public int get(int key) {
		if (memberMap.containsKey(key)) {
			CacheObjectProxy cop = memberMap.get(key);
			if (capacity !=1 && head!=cop) {
				updateHeadAndTail(cop); 
			}
			return cop.value; 
		}
		return -1; 
	}

	private void updateHeadAndTail(CacheObjectProxy cop) {
		if (cop == tail) {
			tail = cop.prev; 
		} else {
			cop.next.prev = cop.prev; 
		}
		cop.prev.next = cop.next;
		head.prev = cop; 
		cop.next = head; 
		cop.prev = null; 
		head = cop;
	}

	public void set(int key, int value) {
		if (memberMap.containsKey(key) ) {
			CacheObjectProxy oldObject = memberMap.get(key); 
			oldObject.value = value; 
			if (head == oldObject) return ;
			updateHeadAndTail(oldObject); 
		} else {
			CacheObjectProxy newObject = new CacheObjectProxy(key, value); 
			
			if (count<capacity) {
				if (head!=null) head.prev = newObject; 
				moveToTop(key, newObject); 
				count++; 
			} else {
				memberMap.remove(tail.key); 
				if (tail.prev!=null) {
					tail.prev.next = null;
					tail = tail.prev; 
				} 
				moveToTop(key, newObject); 
			}	
		}
	}

	private void moveToTop(int key, CacheObjectProxy newObject) {
		if (tail==null) tail = newObject; 
		newObject.next = head; 
		if (head!=null) head.prev = newObject; 
		head = newObject; 
		memberMap.put(key, newObject);
		newObject.prev= null; 
	}
	
	
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2); 
		lru.set(2,1); 
		lru.set(1,1);
		System.out.println(lru.get(2)); 
		lru.set(4,1);
		System.out.println(lru.get(1)); 
		System.out.println(lru.get(2));
//		lru.set(10,13);lru.set(3,17);lru.set(6,11);lru.set(10,5);lru.set(9,10);lru.get(13);lru.set(2,19);
//		lru.get(2);lru.get(3);lru.set(5,25);lru.get(8);lru.set(9,22);
//		lru.set(5,5);lru.set(1,30);lru.get(11);
//		lru.set(9,12);lru.get(7);lru.get(5);lru.get(8);lru.get(9);lru.set(4,30);lru.set(9,3);lru.get(9);lru.get(10);
//		lru.get(10);lru.set(6,14);lru.set(3,1);lru.get(3);lru.set(10,11);lru.get(8);lru.set(2,14);lru.get(1);lru.get(5);lru.get(4);
//		lru.set(11,4);lru.set(12,24);lru.set(5,18);lru.get(13);lru.set(7,23);lru.get(8);lru.get(12);lru.set(3,27);lru.set(2,12);lru.get(5);
//		lru.set(2,9);lru.set(13,4);lru.set(8,18);lru.set(1,7);lru.get(6);lru.set(9,29);lru.set(8,21);lru.get(5);lru.set(6,30);lru.set(1,12);lru.get(10);
//		lru.set(4,15);lru.set(7,22);lru.set(11,26);lru.set(8,17);lru.set(9,29);lru.get(5);lru.set(3,4);lru.set(11,30);lru.get(12);lru.set(4,29);lru.get(3);lru.get(9);
//		lru.get(6);lru.set(3,4);lru.get(1);lru.get(10);lru.set(3,29);lru.set(10,28);lru.set(1,20);lru.set(11,13);lru.get(3);lru.set(3,12);lru.set(3,8);lru.set(10,9);
//		lru.set(3,26);lru.get(8);lru.get(7);lru.get(5);lru.set(13,17);lru.set(2,27);lru.set(11,15);lru.get(12);lru.set(9,19);lru.set(2,15);lru.set(3,16);lru.get(1);
//		lru.set(12,17);lru.set(9,1);lru.set(6,19);lru.get(4);lru.get(5);lru.get(5);lru.set(8,1);lru.set(11,7);lru.set(5,2);lru.set(9,28);lru.get(1);lru.set(2,2);lru.set(7,4);
//		lru.set(4,22);lru.set(7,24);lru.set(9,26);lru.set(13,28);lru.set(11,26); 
	}
	
}

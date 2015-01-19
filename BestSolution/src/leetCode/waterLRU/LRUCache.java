package leetCode.waterLRU;
import java.util.*;

public class LRUCache {
	HashMap<Integer, CacheObjectProxy> members;
    CacheObjectProxy head, tail;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity=capacity; 
        members = new HashMap<Integer, CacheObjectProxy>(); 
    }
    
    public int get(int key) {
        if (members.containsKey(key)){
            CacheObjectProxy proxy = members.get(key); 
            if (proxy!=head) moveToTop(proxy); 
            return proxy.value;
        }
        return -1; 
    }
    
    public void moveToTop(CacheObjectProxy res){
        res.prev.next=res.next;
        if (res.next!=null) res.next.prev=res.prev;
        else tail=res.prev;
        res.prev=null; 
        res.next=head;
        head.prev=res;
        head=res;
    }
    
    public void set(int key, int value) {
        if (members.containsKey(key)) {
            CacheObjectProxy proxy = members.get(key); 
            proxy.value=value; 
            if (proxy!=head) moveToTop(proxy);
        } else {
            CacheObjectProxy proxy = new CacheObjectProxy(key, value); 
            if (members.size()<capacity){
                if (head==null) { head=proxy; tail=proxy; }
                else {tail.next=proxy; proxy.prev=tail; tail=proxy; }
                if (proxy!=head) moveToTop(proxy); 
            } else {
                CacheObjectProxy temp = tail;
                members.remove(temp.key); 
                if (tail==head) { head=proxy; tail=proxy; }
                else {
                    tail.prev.next=proxy; 
                    proxy.prev=tail.prev; 
                    tail=proxy;
                    moveToTop(proxy); 
                }
            }
            members.put(key, proxy); 
        }
    }
    
    class CacheObjectProxy{
        int key; 
        int value;
        CacheObjectProxy prev, next;
        public CacheObjectProxy(int key, int value) {
            this.key=key;
            this.value=value;
        }
    }
}

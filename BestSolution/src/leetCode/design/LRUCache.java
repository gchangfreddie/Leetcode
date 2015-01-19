package leetCode.design;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, LRUProxy> map; 
    LRUProxy head, tail; 
    int capacity; 
    
    public class LRUProxy {
        int key; 
        int val; 
        LRUProxy prev, next;
        public LRUProxy(int key, int value){
            this.key=key; 
            val=value; 
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity=capacity; 
        map = new HashMap<Integer, LRUProxy> (); 
        head=null ;
        tail=null; 
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
           LRUProxy res = map.get(key); 
           if (head!=res){
               moveToTop(res);         
           }
           return res.val;  
        }
        return -1; 
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)){
            LRUProxy res = map.get(key); 
            res.val=value; 
            if (head!=res) moveToTop(res); 
        } else {
            LRUProxy res = new LRUProxy(key, value); 
            if (map.size()<capacity){
                addNewNode(res); 
            } else {
                LRUProxy last = tail; 
                if (tail==head) {head=null; tail=null; }
                else {tail=last.prev; tail.next=null; }
                map.remove(last.key); 
                addNewNode(res); 
            }
            map.put(key, res); 
        }
    }
    
    private void addNewNode(LRUProxy res) {
        if (head==null) { head=res; tail=res;  }
        else {
            tail.next=res; 
            res.prev=tail; 
            tail=res;
            moveToTop(res); 
        }
    }
    
    private void moveToTop(LRUProxy res) {
        if (res!=tail){
            res.next.prev=res.prev;
        } else{
            tail=tail.prev; 
        }
        res.prev.next=res.next; 
        res.prev=null; 
        res.next=head;
        head.prev=res; 
        head=res;
    }
}

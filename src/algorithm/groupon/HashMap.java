package algorithm.groupon;
import java.util.List;

public class HashMap<Key extends Comparable<Key>, Value> {

	Node<Key, Value>[] array;
	
	public HashMap(){
		array = new Node[10]; 
	}
	
	public void set(Key k, Value val){
		int index = k.hashCode()%10; 
		if (array[index]==null) array[index]= new Node<Key, Value>(k, val); 
		else {
			Node<Key, Value> temp = array[index]; 
			while (temp!=null) {
				if (temp.k.compareTo(k)==0) {
					temp.v=val; 
					break;
				} 
				temp=temp.next;
			}
			if (temp==null) {
				Node<Key, Value> node = new Node<Key, Value>(k, val); 
				node.next=array[index]; 
				array[index]=node;
			}
		}
	}
	
	public Value get(Key k){
		int index = k.hashCode()%10; 
		if (array[index]==null) return null; 
		Node<Key, Value> node = array[index]; 
		while (node!=null) {
			if (node.k.compareTo(k)==0) return node.v; 
			node=node.next;
		}
		return null; 
	}
	
	public void delete(Key key){
		int index = key.hashCode()%10; 
		if (array[index]!=null) {
			Node<Key, Value> node = array[index]; 
			Node<Key, Value> prev = new Node<Key, Value>(key, null); 
			prev.next = node; 
			while (node!=null) {
				if (node.k.compareTo(key)==0) prev.next = node.next; 
				else prev=node; 
				node=node.next; 
			}
		}
	}
	
	class Node<Key, Value> {
		Key k; 
		Value v; 
		Node<Key, Value> next;
		public Node(Key key, Value value){
			k=key;
			v=value; 
			next=null; 
		}
	}
	
	public static void main(String[] args){
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.set("Grace", 100000); 
		map.set("Twitter", 120000); 
		map.set("Cisco", 130000); 
		map.set("Groupon", 134000);
		System.out.println(map.get("Groupon"));
	}
}

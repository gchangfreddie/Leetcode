package systemDesign;
import java.util.*;
/*
 * notice: since it is a generic HashMap, use <Key, Value> every where;
 */
public class MineHashTable<Key, Value> {
	LinkedList<Cell<Key, Value>>[] array; 
	int capacity; 
	
	public MineHashTable(int c) {
		capacity = c; 
		array = (LinkedList<Cell<Key, Value>>[])new LinkedList[c]; 
	}
	
	private int hashCode(Key key){
		return key.toString().length()%capacity;
	}
	
	public void put(Key k, Value v){
		int hashCode = hashCode(k); 
		if (array[hashCode]==null) {
			array[hashCode]= new LinkedList<Cell<Key, Value>>(); 
		} else {
			for (Cell<Key, Value> cell : array[hashCode]){
				if (cell.key.equals(k)) {
					array[hashCode].remove(cell); 
					break;
				}
			}
		}
		array[hashCode].add(new Cell<Key, Value>(k, v)); 
		
	}
	
	public Value get(Key k){
		int hashCode = hashCode(k); 
		if (array[hashCode]!=null) {
			for (Cell<Key, Value> cell : array[hashCode]){
				if (cell.key.equals(k)) {
					return cell.value; 
				}
			}
		}
		return null; 
	}
	
}

class Cell<Key, Value>{
	public Key key; 
	public Value value; 
	public Cell(Key k, Value v){
		key=k;
		value=v; 
	}
}

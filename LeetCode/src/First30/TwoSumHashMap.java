package First30;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class TwoSumHashMap {
	public int[] twoSum(int[] numbers, int target) {
	    HashMap<Integer, Integer> h = new HashMap<Integer, Integer>(); 
	    int[] result = new int[2]; 
	    
	    for (int i=0; i<numbers.length; i++) { // put and search in the same loop
	    	if (h.containsKey(numbers[i])) { // there is already the other value
	    		result[0] = h.get(numbers[i]) + 1;
	    		result[1] = i+1; 
	    		break; 
	    	} else {
	    		h.put(target-numbers[i], i); // put the expected value as the key and the index of array as the value
	    	}
	    }
	    return result; 
    }
	/*In real-life hashing, it’s not uncommon to have more than one entry in a bucket. Hashing retrieval is a two-step process.
	1. Find the right bucket (using hashCode()), that means even diff objects can return same hash code
	2. Search the bucket for the right element (using equals() ).*/
	
	//Time complexity of this solution: O(n).
	
	public static void main(String[] args){
    	int[] a = new int[]{15,7,21,1,33,4,9}; 
    	TwoSumHashMap ts = new TwoSumHashMap(); 
    	
    	int[] b = ts.twoSum(a, 25); 
    	
    	for (int i=0; i<b.length; i++){
    		System.out.print(" " + b[i]);
    	}
    	
    }
}

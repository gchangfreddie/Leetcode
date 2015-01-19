package Cisco;
import java.util.*;
public class SortByAge {
	public static List<Integer> sort(List<Integer> records){
		List<Integer>[] res = (List<Integer>[]) new ArrayList[120]; //0 - 120
		for (int i=0; i<120; i++) {
			res[i] = new ArrayList<Integer>(); 
		}
		for (Integer i : records) 
			res[i].add(i); 
		List<Integer> list = new ArrayList<Integer>(); 
		for (List<Integer> l : res){
			list.addAll(l); 
		}
		return list;
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>(); 
		list.add(99); list.add(19); 
		list.add(34); list.add(109); list.add(0); 
		list.add(9); list.add(14); 
		list.add(31); list.add(119); list.add(50); 
		for (int i: list) System.out.print(i+ " ");
		System.out.println();
		list = sort(list); 
		for (int i: list) System.out.print(i+ " ");
		System.exit(0);
	}
}

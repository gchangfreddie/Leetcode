package systemDesign;

import java.util.*;


/*
 * Auth: Grace Chang (gracechang007@gmail.com)
 */
public class Directory {
	
	private String name; 
	private String path; 
	protected Directory parent; 
	private HashMap<String, Directory> children; 
	
	public Directory(String n, Directory d) {
		name = n; 
		path = d==null ? "" : d.getPath() + "/" + name; 
		parent = d; 
		children = new HashMap<String, Directory>(); 
	}
	
	/*
	 * get path for this directory 
	 */
	public String getPath() {
		return path; 
	}
	
	/*
	 * get name for this directory
	 */
	public String getName() {
		return name; 
	}
	
	/* 
	 * check whether is directory is empty
	 */
	public boolean isEmptyDir() {
		return children.size()==0; 
	}
	
	/*
	 * remove sub dircetory 
	 */
	public boolean removeSubDir(String name) {
		if (children.containsKey(name)) {
			Directory dir = children.get(name); 
			if (dir.isEmptyDir()) {
				children.remove(name); 
				return true;
			} 
			return false; 
		}
		return false;
	}
	
	/*
	 * return a set for all sub directory name
	 */
	public Set<String> getChildren(){
		return children.keySet(); 
	}
	
	/* 
	 * add a new directory 
	 */
	public boolean add(String name, Directory child){
		if (children.containsKey(name)) return false; 
		children.put(name, child); 
		return true; 
	}
	
	/* 
	 * go to sub directory
	 */
	public Directory goSubDir(String child){
		if (children.containsKey(child)) {
			return children.get(child); 
		} else {
			return null; 
		}
	}
	
}

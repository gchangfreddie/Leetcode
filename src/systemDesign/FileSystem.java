package systemDesign;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/*
 * Author: Grace Chang  (gracechang007@gmail.com)
 */
public class FileSystem {

	private static FileSystem fileSystem;
	private Directory root;
	private HashMap<String, Directory> dirMap; 
	private Directory current; 
	
    /*
     * use Singleton Design pattern to keep global configuration in FileSystem instance
     */
	private FileSystem() {
		root = new Directory("", null); 
		dirMap = new HashMap<String, Directory>(); 
		current = root; 
	}
	
	public static FileSystem getInstance(){
		if (fileSystem==null) fileSystem = new FileSystem(); 
		return fileSystem; 
	}
	
	/*
	 * for command "mkdir" 
	 */
	public boolean createDirctory(String name) {
		if (isValidDirName(name)) {
			Directory d =  new Directory(name, current); 
			boolean res = current.add(name, d); 
			if (res) {
				dirMap.put(name, d) ; 
				return true; 
			} 
			return false; 
		}
		return false; 
	}
	
	/* 
	 * for command "cd"
	 */
	public void changeWorkingDir(String dir) {
		if (dir.equals(".")) return ; 
		if (dir.equals("..")) {
			current = current == root ? root : current.parent; 
		} else {
			Directory res = current.goSubDir(dir); 
			if (res!=null) current = res; 
		}
	}
	
	/* 
	 * for command "pwd"
	 */
	public void getCurrentPath(){
		if (current==root) System.out.println("/");
		else System.out.println(current.getPath()); 
	}
	
	/*
	 * for command "ls" 
	 */
	public void listDirs() {
		if (current.isEmptyDir()) {
			System.out.println("it is a empty directoyr");
		} else {
			Set<String> res = current.getChildren(); 
			for (String name : res) {
				System.out.print(name + " ");
			}
			System.out.println();
		}
	}
	
	/* 
	 * for command "rmdir"
	 */
	public void removeDir(String name) {
		if (!dirMap.containsKey(name)) return; 
		else {
			boolean res = current.removeSubDir(name); 
			if (res) dirMap.remove(name); 
		}
	}
	
	/*
	 * directory name must be 0-9 and A-Z or a-z
	 */
	private boolean isValidDirName(String name){
		if (!Pattern.matches("[a-zA-Z0-9-_]{1,200}", name)) {
			System.out.println(name + " is not valid. Please use a valid name for directory" );
			return false; 
		}
		return true; 
	}
	
	private boolean isValidSSN(String ssn){
		/**
		 * Can also use String.matches(re)
		 */
		return Pattern.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}", ssn) ;
	}
	
	private boolean isValideEmail(String email){
		return Pattern.matches("[a-zA-Z0-9-._]+@([a-zA-Z]+.)+(edu|com)", email); 
	}
	
	private boolean isValidJavaIdentifier(String identifier){
		return Pattern.matches("[a-zA-Z_$][a-zA-Z_$0-9]*", identifier); 
	}
	
	
	public static void main(String[] args){
		FileSystem fs = FileSystem.getInstance(); 
		
		File file = new File("C:/JobHunting/input.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = new String(); 
			
			while ((line = br.readLine()) != null) {
				String[] command = line.split(" "); 
				if (command[0].equals("mkdir")) {
					fs.createDirctory(command[1]); 
				} else if (command[0].equals("cd")) {
					fs.changeWorkingDir(command[1]); 
				} else if (command[0].equals("pwd")) {
					fs.getCurrentPath();
				} else if (command[0].equals("rmdir")) {
					fs.removeDir(command[1]); 
				} else if (command[0].equals("ls")) {
					fs.listDirs(); 
				}

			}
			br.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
}

package Cisco;

public class Singleton {
	private static Singleton instance; 
	private Singleton(){
		
	}
	public synchronized Singleton getInstance(){
		if (instance == null) {
			instance = new Singleton(); 
		}
		return instance;
	}
	
}

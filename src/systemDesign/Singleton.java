package systemDesign;

public class Singleton {
	private static Singleton instance=null; 
	
	private Singleton(){
	}
	
	public static synchronized Singleton getInstance(){
		if (instance==null) {
			synchronized (Singleton.class) {//can't use this in a static context
				if (instance==null) //double check
					instance=new Singleton();
			}
		}
		return instance;
	}
}

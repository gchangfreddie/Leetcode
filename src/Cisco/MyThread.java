package Cisco;

public class MyThread implements Runnable{
	public void run() {
		try {
			Thread.sleep(36000000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		while(true) {
			// log in 
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("log in test");
		}
	}
	
	public static void main(String[] args){
		Runnable r = new MyThread(); 
		Thread t = new Thread(r); 
		t.start(); 
	}
}

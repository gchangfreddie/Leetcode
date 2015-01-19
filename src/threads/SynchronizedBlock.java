package threads;

public class SynchronizedBlock extends Thread{
	public StringBuilder sb; 
	public void run(){
		synchronized (sb) {
			for (int i=0 ;i<9; i++)
				System.out.print(sb + " ");
			char c = sb.charAt(0); 
			sb.replace(0, 1, String.valueOf((char)(c+1))); 
		}
	}
	
	public SynchronizedBlock(StringBuilder sb) {
		this.sb=sb; 
	}
	
	public static void main(String[] args) {
		StringBuilder ssb = new StringBuilder("a");
		for (int i=0; i<3; i++) {
			SynchronizedBlock sb = new SynchronizedBlock(ssb); 
			sb.start(); 
		}
	}
}

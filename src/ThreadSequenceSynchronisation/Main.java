package ThreadSequenceSynchronisation;

public class Main {
	
	public static void main(String[] args) {
		
		SharedResourceEvenOdd obj = new SharedResourceEvenOdd();
		
		Thread evenThread = new Thread(() ->{
			try {
				obj.print(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread oddThread = new Thread(() ->{
			try {
				obj.print(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		oddThread.start();
		evenThread.start();
	}
}

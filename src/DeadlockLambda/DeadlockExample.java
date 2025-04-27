package DeadlockLambda;

public class DeadlockExample{



	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		String res1 = "Sanjay";
		String res2 = "Priya";
		
		Thread thread1 = new Thread(() -> {
			synchronized(res1) {
				System.out.println("Resource 1 Thread 1 has locked");
				
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				System.out.println("Thread 1 wants Resource 2");
			synchronized(res2) {
				System.out.println("Resource 2 Thread 1 has locked");
			 }
		   }	
			
		});
		
		Thread thread2 = new Thread(() -> {
			synchronized(res2) {
				System.out.println("Resource 2 Thread 2 has locked");
				
				System.out.println("Thread 2 wants Resource 1");
			synchronized(res1) {
				System.out.println("Resource 1 Thread 2 has locked");
			}	
		  }
		});
		
		thread1.start();
		//thread1.join(); // to Avoid Deadlock, Main thread will wait here. once t1 is done then execute T2
		thread2.start();
	}

	
}

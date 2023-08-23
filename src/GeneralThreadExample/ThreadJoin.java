package GeneralThreadExample;

public class ThreadJoin extends Thread{

	public void run() {
		try {
			ThreadJoin.printThread1();
			ThreadJoin.printThread2();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	 public static void printThread1() throws InterruptedException {
		 if(Thread.currentThread().getName().equals("T1")) {
		for(int i =1;i<=10;i++) {
				System.out.println(Thread.currentThread().getName()+" Value "+i+" "+Thread.currentThread().getPriority());
			
		}
	  }
	}
	 
	 public static void printThread2() throws InterruptedException {
		 if(Thread.currentThread().getName().equals("T2")) {
			for(int i =1;i<=10;i++) {
					System.out.println(Thread.currentThread().getName()+" Value "+i+" "+Thread.currentThread().getPriority());
				
			}
		  }
		}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadJoin thread1 = new ThreadJoin();
		thread1.setName("T1");
		thread1.setPriority(1);
		
		ThreadJoin thread2 = new ThreadJoin();
		thread2.setName("T2");
		thread2.setPriority(10);
		
		//thread1.setPriority(8);
		thread1.start();
		//thread1.join();
		thread2.start();
		//thread2.join(); // means this thread will would terminate first before execution of any other instruction.
		
		System.out.println(Thread.currentThread().getName());

	}

}

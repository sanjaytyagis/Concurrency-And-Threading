package MonitorLockExample;
/*
   Runnable runnable = () -> { 
    // your code here ...
	};
	Thread t = new Thread(runnable);
	t.start();
	
	Thread t = new Thread(() -> {
    // your code here ...
	});
	
 */
public class MonitorLockExample {

	public synchronized void task1() {
		try {
			System.out.println("Inside Task1");
			Thread.sleep(10000); // sleep didn't release the lock
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void task2() {
	System.out.println("Task2 Before Synchronised"); // T2 would wait till 10 seconds to get a lock and then It would print
		synchronized (this) {
			System.out.println("Task2 Inside Synchronised");
		}
	}
	
	public void task3() { // T3 didn't ask for lock so it's executed
		System.out.println("Inside Task3");
	}
	
	public static void main(String[] args) {
		
		MonitorLockExample obj = new MonitorLockExample();
		// Sequence Execution of Threads aren't guaranteed
		
		Thread t1 = new Thread(()->{obj.task1();}); // T1 will acquire a lock not on method but on Object
		Thread t2 = new Thread(()->{obj.task2();}); // T2 try to acquire but T1 has already acquired, it will get after release by T1
		Thread t3 = new Thread(()->{obj.task3();}); // T3 won't acquire a lock, As no synchronized block is there 
		t1.start();
		t2.start();
		t3.start();
	}
}
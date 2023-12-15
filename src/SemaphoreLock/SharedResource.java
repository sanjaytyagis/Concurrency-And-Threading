package SemaphoreLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

	boolean isAvaiable = false;
	Semaphore lock = new Semaphore(2); // 2 means two thread can acquire the lock at a time
	
	public void producer() {
		try {
			lock.acquire();
			System.out.println("Lock acquired By"+Thread.currentThread().getName());
			isAvaiable = true;
			Thread.sleep(4000);
		} catch (Exception e) {
			
		}
		finally {
			lock.release();
			System.out.println("Lock released By"+Thread.currentThread().getName());
		}
	}
}

package ReetrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
	
	boolean isAvaiable = false;
	//ReentrantLock lock = new ReentrantLock();
	
	public void produce(ReentrantLock lock) {
		try {
			lock.lock();
			
			System.out.println("Lock acquired By"+Thread.currentThread().getName());
			isAvaiable = true;
			Thread.sleep(4000);
			System.out.println("Sleep Execute");
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			lock.unlock();
			System.out.println("Lock released By"+Thread.currentThread().getName());
		}
	}
}

package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

	boolean isAvaiable = false;
	
	public void producer(ReadWriteLock lock) {
		try {
			lock.readLock().lock();
			System.out.println("Read Lock acquired By"+Thread.currentThread().getName());
			isAvaiable = true;
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			lock.readLock().unlock();
			System.out.println("Read Lock released By"+Thread.currentThread().getName());
		}
	}
	
	public void consume(ReadWriteLock lock) {
		try {
			lock.writeLock().lock();
			System.out.println("Write Lock acquired By"+Thread.currentThread().getName());
			isAvaiable = false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			lock.writeLock().unlock();
			System.out.println("Write Lock released By"+Thread.currentThread().getName());
		}
	}
}

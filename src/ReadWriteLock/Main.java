package ReadWriteLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedResource resource = new SharedResource();
		
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		Thread th1 = new Thread(() -> {
			resource.producer(lock);
		});
		
		Thread th2 = new Thread(() -> {
			resource.producer(lock);
		});
		
		SharedResource resource1 = new SharedResource();
		Thread th3 = new Thread(() -> {
			resource1.consume(lock);
		});
		
		th1.start();
		th2.start();
		th3.start();
	}
}

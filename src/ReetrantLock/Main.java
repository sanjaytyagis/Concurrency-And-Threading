package ReetrantLock;
import java.util.concurrent.locks.ReentrantLock;

import ProducerConsumerLambda.SharedResource;

// In Reetrant Lock only one thread would go to critical section instead of all threads
public class Main {

	public static void main(String[] args) {
		
		ReetrantLock.SharedResource obj = new ReetrantLock.SharedResource();
		
		Thread th1 = new Thread(() -> {
			obj.produce();
		});
		
		Thread th2 = new Thread(() -> {
			obj.produce();
		});
		
		th1.start();
		th2.start();
	}

}

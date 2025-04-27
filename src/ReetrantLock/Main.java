package ReetrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import ProducerConsumerLambda.SharedResource;

/*

 lock()		Acquires the lock. If someone else holds it, you wait (block).
 unlock()	Releases the lock so someone else can acquire it.

 In contrast to synchronized:
 synchronized locks on an object instance (e.g., synchronized (this) locks the current object), 
 whereas ReentrantLock only locks on the instance of ReentrantLock itself.

 When you instantiate a ReentrantLock object, that specific instance is what threads lock and unlock, 
 not the object that contains the lock.
 If multiple threads are using the same ReentrantLock instance, they will compete for that lock.
 If each thread has its own separate ReentrantLock instance,
 they will not block each other because they are locking different objects.
 
 private final Condition permitsAvailable = lock.newCondition(); 
 
 // await, signal method of condition object
 The thread calls the await() atomically releases the lock and suspends the thread
 
 The thread calls calls signal() or signalAll() This wakes up one or all waiting threads, respectively.
 */
public class Main {

	public static void main(String[] args) {
		
		ReetrantLock.SharedResource obj = new ReetrantLock.SharedResource();

		ReentrantLock lock = new ReentrantLock();
		Condition con =  lock.newCondition();
		
		Thread th1 = new Thread(() -> {
			obj.produce(lock);
		});
		
		Thread th2 = new Thread(() -> {
			obj.produce(lock);
		});
		
		th1.start();
		th2.start();
	}
}

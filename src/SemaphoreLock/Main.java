package SemaphoreLock;

/*
 * A semaphore is a counter that controls how many threads can access a resource at the same time.

Type				Meaning

Counting Semaphore	Allows up to N threads
Binary Semaphore	Special case with only 1 permit (works like a simple lock)
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedResource resource = new SharedResource();

		
		Thread th1 = new Thread(() -> {
			resource.producer();
		});
		
		Thread th2 = new Thread(() -> {
			resource.producer();
		});
		
		Thread th3 = new Thread(() -> {
			resource.producer();
		});
		
		Thread th4 = new Thread(() -> {
			resource.producer();
		});
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}

}

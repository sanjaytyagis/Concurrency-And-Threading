package CountDownLatch;
/*
   A CountDownLatch is a synchronization tool that waits until a count becomes zero.
   Threads wait until other threads finish their work.
   
   	Normally, CountDownLatch internally uses:

	A count to track remaining tasks.
	A Lock to protect count (atomic operations).
	A Condition to make threads wait if the count > 0.
	
	Method			Meaning
	await()			Lock + Wait until count = 0
	countDown()		Lock + Decrement count + Signal when count = 0
✅ Threads calling await() wait until countDown() reduces the count to zero!
 */
public class Main {
// Every thread needs to call await() to check can I finish my work or needs to wait.
	public static void main(String[] args) throws InterruptedException {
		
		CustomCountDownLatch latch = new CustomCountDownLatch(3); // Need 3 countdowns

        for (int i = 1; i <= 3; i++) {
        	
            final int id = i;
            new Thread(() -> {
                try {
                    System.out.println("Worker-" + id + " is working...");
                    Thread.sleep(2000);
                    
                    System.out.println("Worker-" + id + " finished work.");
                    
                    latch.countDown(); // Each worker reduces the latch
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("Main thread waiting for workers...");
        
        latch.await(); // Wait for all workers to finish
        System.out.println("All workers finished. Main thread continues!");

	}

}

package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
    CyclicBarrier is a synchronization aid that allows 
    a set of threads to wait for each other at a common barrier point.

	Once all threads reach the barrier, they are released together.

	Cyclic means: after releasing, the barrier can be reused again!

📦 CyclicBarrier vs CountDownLatch
CountDownLatch → "I will wait for you to finish."
CyclicBarrier → "We will all wait for each other, then move together."

Feature						CountDownLatch												CyclicBarrier

Reusable?			❌ (One-time use)								✅ (Cyclic, reusable)
Who waits?			One or more waiting 							for others	All threads must wait

Resets?				❌ One-time use only. Cannot reset.				✅ Resets automatically after all threads arrive.
Who waits?			Only the thread calling await() has to wait		All threads calling await() must wait for each other
Barrier Action?		❌ No special action when count reaches 0,		✅ Can run an extra action when all threads reach
Usage Example		Waiting for a service to finish loading 		Waiting for all worker threads to finish their phase before moving together
					before starting APP
Threads				Main thread usually waits.						All participant threads wait.

*/
public class Main {
/*
    We need a counter to track how many threads have reached the barrier.
	We need a Lock to protect this counter.
	We need a Condition to make threads wait until everyone arrives.
	When the last thread arrives, wake up all waiting threads.
 */
	public static void main(String[] args) {
        int numberOfThreads = 3;
        
        CustomCyclicBarrier barrier = new CustomCyclicBarrier(numberOfThreads, 
            () -> System.out.println("All threads reached barrier. Let's continue!"));

        for (int i = 1; i <= numberOfThreads; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread-" + id + " is working...");
                    Thread.sleep(1000 * id); // Simulate work
                    System.out.println("Thread-" + id + " reached barrier.");
                    barrier.await(); // Wait for others
                    System.out.println("Thread-" + id + " continues after barrier.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
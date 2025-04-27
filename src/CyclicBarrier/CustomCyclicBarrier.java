package CyclicBarrier;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/*
 Thing					Meaning
 
lock.lock()				Safe counter updates
count--					Thread arrives
condition.await()		Wait if not all arrived
condition.signalAll()	Wake everyone when all arrived
count = parties			Reset for reuse (cyclic nature)

 */
public class CustomCyclicBarrier {
    
    private final int parties;      // Total threads to wait for
    private int count;              // Current number of waiting threads
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Runnable barrierAction; // Optional action to run when barrier is tripped

    public CustomCyclicBarrier(int parties, Runnable barrierAction) {
        this.parties = parties;
        this.count = parties;
        this.barrierAction = barrierAction;
    }

    public CustomCyclicBarrier(int parties) {
        this(parties, null);
    }

    public void await() throws InterruptedException {
        lock.lock();
        try {
            count--;
            if (count == 0) {
                // Last thread arrives
                if (barrierAction != null) {
                    barrierAction.run(); // Optional action
                }
                count = parties; // Reset for next use
                condition.signalAll(); // Wake up all waiting threads
            } else {
                while (count != parties) {
                    condition.await(); // Wait for others
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

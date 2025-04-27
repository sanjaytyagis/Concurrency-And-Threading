package SemaphoreLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomSemaphore {

    private int permits;
    private final Lock lock = new ReentrantLock();
    private final Condition permitsAvailable = lock.newCondition();

    public CustomSemaphore(int initialPermits) {
        this.permits = initialPermits;
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits == 0) {
                permitsAvailable.await(); // Wait if no permits available
            }
            permits--; // Take a permit
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            permits++; // Give back a permit
            permitsAvailable.signal(); // Wake up waiting thread
        } finally {
            lock.unlock();
        }
    }
}

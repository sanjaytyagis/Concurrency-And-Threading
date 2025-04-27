package CountDownLatch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomCountDownLatch {

    private int count;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public CustomCountDownLatch(int count) {
        this.count = count;
    }

    public void await() throws InterruptedException {
        lock.lock();
        try {
            while (count > 0) {
                condition.await(); // Wait until count reaches 0
            }
        } finally {
            lock.unlock();
        }
    }

    public void countDown() {
        lock.lock();
        try {
            if (count > 0) {
                count--;
            }
            if (count == 0) {
                condition.signalAll(); // Wake up all waiting threads
            }
        } finally {
            lock.unlock();
        }
    }
}
package ExecutorServiceThreadPool;
import java.util.concurrent.*;

/*
ThreadPoolExecutor: Here, we created a thread pool with a core pool size of 2 and a maximum pool size of 4. 
This means that the pool will initially have 2 threads, 
and it can increase the number of threads to 4 if needed. 
The idle threads will be terminated after 10 seconds.

ExecutorService: The submit() method is used to submit tasks to the executor. 
Each task will print out its status, simulating work with Thread.sleep().

Graceful Shutdown: The shutdown() method ensures that no new tasks are accepted, 
and awaitTermination() waits until all tasks have been completed before the program exits.


 */
public class ThreadPoolExample {

	public static void main(String[] args) throws InterruptedException {
		 // Step 1: Create a ThreadPoolExecutor with a core pool size of 2 and maximum pool size of 4
        ExecutorService executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        // Step 2: Submit tasks to the pool
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Task " + taskId + " is being processed by " + Thread.currentThread().getName());
                    Thread.sleep(1000); // Simulate work
                    System.out.println("Task " + taskId + " is completed by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Step 3: Shut down the executor after tasks are completed
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES); // Wait for all tasks to complete
   

	}

}

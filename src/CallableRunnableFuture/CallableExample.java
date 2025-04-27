package CallableRunnableFuture;
import java.util.concurrent.*;

/*
  Callable is similar to Runnable but with a key difference:
  Runnable cannot return a result or throw a checked exception, while Callable can.

  The Callable interface is used for tasks that can be executed asynchronously and can return a result or throw an exception.
 
 Future Interface:
	Future represents the result of an asynchronous computation. 
	It allows you to retrieve the result of a Callable task when it's ready (or wait for it to complete).

	Future provides methods like:

	get(): Retrieves the result of the computation (blocks until the result is available).
	cancel(): Cancels the execution of the task.
	isDone(): Checks if the task is completed.
	isCancelled(): Checks if the task was cancelled before it was completed.
 */
public class CallableExample implements Callable<Integer> {
    
	@Override
    public Integer call() throws Exception {
        // Simulate some computation
        Thread.sleep(1000);
        return 42;  // Return a result
    }
    
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Create a thread pool with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        
        // Create a Callable task
        Callable<Integer> task = new CallableExample();
        
        Callable<Integer> task1 = () -> {
        									System.out.println();
        									return 4;
        								};
        						
        Runnable task2 = () -> 	{
        							System.out.println();
        						};							
        // Submit the task to the executor
        Future<Integer> future = executorService.submit(task);

        // Do some other work (simulate with sleep)
        System.out.println("Main thread doing other work...");

        // Get the result of the task (this blocks until the task is done)
        Integer result = future.get();  // Will wait until task is finished

        // Print the result
        System.out.println("Task result: " + result);
        
        // Shutdown the executor service
        executorService.shutdown();
	}

}

package ForkJoin;

import java.util.concurrent.*;

public class ForkJoinExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Create a ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        
        // Create the task to compute the sum
        SumTask task = new SumTask(numbers, 0, numbers.length);
        
        // Submit the task to the pool and get the result
        Integer result = forkJoinPool.submit(task).get();
        
        // Print the result
        System.out.println("Sum: " + result);
        
        // Shutdown the pool
        forkJoinPool.shutdown();
    }
	
}

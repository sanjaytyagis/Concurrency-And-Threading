package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
/*
  supplyAsync() runs the task asynchronously (like on a different thread from ForkJoinPool.commonPool()).


 */
public class CompletableFutureExample {

	public static void main(String[] args) {
        System.out.println("Main thread started: " + Thread.currentThread().getName());

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Simulate long task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data from database";
        });

        // Attach callback
        future.thenAccept(result -> {
            System.out.println("Received: " + result + " in thread: " + Thread.currentThread().getName());
        });

        System.out.println("Main thread doing other work...");

        // Optional: wait for completion (only if you want to block)
        future.join(); // block main until future completes
        
        /*
         ✅ Chaining multiple async tasks:

		CompletableFuture.supplyAsync(() -> "Hello")
    												.thenApply(data -> data + " World")
    												.thenAccept(System.out::println);
         */
    }

}

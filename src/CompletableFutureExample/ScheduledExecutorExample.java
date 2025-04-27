package CompletableFutureExample;

import java.util.concurrent.*;

public class ScheduledExecutorExample {

	public static void main(String[] args) {
		
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule task to run after 5 seconds
        scheduler.schedule(() -> {
            System.out.println("Task executed after 5 seconds delay.");
        }, 5, TimeUnit.SECONDS);

        // Schedule task to run every 3 seconds after an initial delay
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Repeated task every 3 seconds: " + System.currentTimeMillis());
        }, 2, 3, TimeUnit.SECONDS);

        // (optional) shutdown after some time
        // scheduler.shutdown();
    }

}

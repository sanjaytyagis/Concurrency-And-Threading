package SemaphoreLock;

public class CustomSemaphoreTest {
    public static void main(String[] args) {
    	
        CustomSemaphore semaphore = new CustomSemaphore(3); // 3 permits available

        for (int i = 1; i <= 6; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    System.out.println("Worker-" + id + " is waiting for a permit...");
                    semaphore.acquire();
                    System.out.println("Worker-" + id + " got a permit!");

                    Thread.sleep(2000); // Simulate some work

                    System.out.println("Worker-" + id + " releasing permit...");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

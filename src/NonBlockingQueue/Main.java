package NonBlockingQueue;

public class Main {

	public static void main(String[] args) {
		SharedResource sharedBuffer = new SharedResource(3);
		
		Thread producerThread = new Thread(()->{
			try {
				for (int i = 1; i <= 6; i++) {
					sharedBuffer.produce(i);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		});

		Thread consumerThread = new Thread(()->{
			try {
				for (int i = 1; i <= 6; i++) {
					sharedBuffer.consume(i);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		
		producerThread.start();
		consumerThread.start();
	}

}

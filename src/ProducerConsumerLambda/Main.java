package ProducerConsumerLambda;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedResource obj = new SharedResource();
		
		Thread producerThread = new Thread(() -> {
			try {
/* 		As thread execution isn't guaranteed So, to run the consumer thread we have used sleep, bcoz consumer will
		start first for SharedResource, If all needs to work fine.
*/
				Thread.sleep(2000); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			obj.addItem();
		});
		
		Thread consumerThread = new Thread(() -> {
			obj.consumeItem();
		});
		
		producerThread.start();
		consumerThread.start();
	}

}

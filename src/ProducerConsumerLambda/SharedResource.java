package ProducerConsumerLambda;

public class SharedResource {

	boolean isItemPresent = false;
	
	public synchronized void addItem() {
		isItemPresent = true;
		System.out.println("Producer Thread Produce the Item");
		notifyAll();
	}
	
	public synchronized void consumeItem() {

		System.out.println("Consumer thread trying to Consume");
// while used because in case of any noise thread can wake-up without notify else if can also be used, Mentioned by oracle		
		while(!isItemPresent) { // checking Item available or not
			try {
				System.out.println("Consumer thread waiting to Consume");
				wait(); // ask to release the monitor lock by current thread
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Consumer thread Consume the Item");
		isItemPresent = false;
	}

}

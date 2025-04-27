package NonBlockingQueue;
import java.util.*;

public class SharedResource {

	private Queue<Integer> sharedBuffer;
	private int bufferSize;
	
	public SharedResource(int bufferSize) {
		sharedBuffer = new LinkedList<>();
		this.bufferSize = bufferSize;
	}
	
	public synchronized void produce(int item) throws Exception {
		
		while(bufferSize == sharedBuffer.size()) {
			System.out.println("Buffer Is Full Don't Produce");
			wait();
		}
		sharedBuffer.add(item);
		System.out.println("Produced : "+ item);
		notify();
	}
	
	public synchronized int consume(int item) throws Exception {
		
		while(sharedBuffer.isEmpty()) {
			System.out.println("Buffer Is Empty Don't Consume");
			wait();
		}
		int itemc = sharedBuffer.poll();
		System.out.println("Comsumed : "+ item);
		notify();
		return itemc;
	}
	
}

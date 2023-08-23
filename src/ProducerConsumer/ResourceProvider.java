package ProducerConsumer;

public class ResourceProvider {
	
	public static void main(String[] args) {
		Shop c = new Shop();
        Producer p1 = new Producer(c,1);
        Consumer c1 = new Consumer(c,1);
        p1.start();
        c1.start();
        
  }

}

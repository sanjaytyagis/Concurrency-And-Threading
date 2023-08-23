package ProducerConsumer;

public class Shop {
    
	private int materials;
    private boolean available = false;
    public synchronized int get()
    {
          while (available == false)
          {
                try
                {
                      wait(); // current thread will wait not the other thread
                }
                catch (InterruptedException ie)
                {
                }
          }
          available = false;
          notifyAll(); // notify other thread you come and start consume
          return materials;
    }
    public synchronized void put(int value)
    {
          while (available == true)
          {
                try
                {
                      wait();
                }
                catch (InterruptedException ie)
                {
                      ie.printStackTrace();
                }
          }
          materials = value;
          available = true;
          notifyAll();
    }
}
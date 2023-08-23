package ProducerConsumer;

public class Producer extends Thread
{
    private Shop Shop;
    private int number;

    public Producer(Shop c, int number)
    {
          Shop = c;
          this.number = number;
    }
    
    public void run()
    {
          for (int i = 0; i < 10; i++)
          {
                Shop.put(i);
                System.out.println("Produced value " + this.number+ " put: " + i);
                try
                {
                      sleep((int)(Math.random() * 100));
                }
                catch (InterruptedException ie)
                {
                      ie.printStackTrace();
                }
          }
    }
}
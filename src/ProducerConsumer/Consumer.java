package ProducerConsumer;

public class Consumer extends Thread
{
    private Shop Shop;
    private int number;
    
    
    public Consumer(Shop c, int number)
    {
          Shop = c;
          this.number = number;
    }
    public void run()
    {
          int value = 0;
          for (int i = 0; i < 10; i++)
          {
                value = Shop.get();
                System.out.println("Consumed value " + this.number+ " got: " + value);
          }
    }
}
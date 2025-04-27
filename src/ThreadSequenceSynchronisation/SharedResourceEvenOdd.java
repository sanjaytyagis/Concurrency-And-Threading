package ThreadSequenceSynchronisation;

public class SharedResourceEvenOdd {
	
	int number = 1;
	
	public void print(int num) throws InterruptedException {
		
		while(number<10) 
		{
			synchronized (this) 
			{
				if(number %2 != num) { // num used to maintain thread synchronisation among two threads
				wait();
				}
				
				System.out.println("Thread Name "+num+" "+number);
				number++;
				notifyAll();
			}
		}
	}
}

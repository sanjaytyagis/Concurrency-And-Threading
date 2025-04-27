package ThreadSequenceSynchronisation;
/*
    Blocked (when multiple threads trying to execute synchrozised block)
			A thread that is blocked waiting for a monitor lock is in this state.

	Waiting
			A thread that is waiting indefinitely for another thread to perform a particular action is in this state
			
    We will use concept of remainder here.

	If number%3==1 then T1 will print the number and increment it else will go in the wait state.
	If number%3==2 then T2 will print the number and increment it else will go in the wait state.
	If number%3==0 then T3 will print the number and increment it else will go in the wait state.

 */
public class SequenceNumbersThread extends Thread {
	
	public int PRINT_NUMBERS_UPTO=10;
    static int  number=1;
    int remainder;
    static Object lock=new Object();
 
    SequenceNumbersThread(int remainder)
    {
        this.remainder=remainder;
    }
 
    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO-1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // When number and reminder equal then number would print by thread
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
	
	public static void main(String[] args) {
		
		SequenceNumbersThread runnable1=new SequenceNumbersThread(1);
		SequenceNumbersThread runnable2=new SequenceNumbersThread(2);
		SequenceNumbersThread runnable3=new SequenceNumbersThread(0);
		runnable1.setName("T1");
		runnable2.setName("T2");
		runnable3.setName("T3");
		runnable1.start();
		runnable2.start();
		runnable3.start();   
		
	}

}

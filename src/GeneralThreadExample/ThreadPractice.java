package GeneralThreadExample;

public class ThreadPractice extends Thread {
	
	public int PRINT_NUMBERS_UPTO=10;
    static int  number=1;
    int remainder;
    static Object lock=new Object();
 
    ThreadPractice(int remainder)
    {
        this.remainder=remainder;
    }
 
    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO-1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // wait for numbers other than remainder
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
		
		ThreadPractice runnable1=new ThreadPractice(1);
		ThreadPractice runnable2=new ThreadPractice(2);
		ThreadPractice runnable3=new ThreadPractice(0);
	 
	        Thread t1=new Thread(runnable1,"T1");
	        Thread t2=new Thread(runnable2,"T2");
	        Thread t3=new Thread(runnable3,"T3");
	 
	        t1.start();
	        t2.start();
	        t3.start();   
		
	}

}

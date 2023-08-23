package GeneralThreadExample;

public class ThreadPractice extends Thread {
	static int c=0;
	public void run() {
		try {
			ThreadPractice.printCounting();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printCounting() throws InterruptedException {
		for(int i =1,j=11;i<=10 || j<=20;i++,j++) {
			
			if(Thread.currentThread().getName().equals("T1")) {
				c++;
				System.out.println(Thread.currentThread().getName()+" Value "+i+" "+c);
				Thread.currentThread().sleep(100);
				
			}
			// local variable in run method creates separate copy for each thread in memory
			if(Thread.currentThread().getName().equals("T2")) {
				c++;
				System.out.println(Thread.currentThread().getName()+" Value "+i+" "+c);
				Thread.currentThread().sleep(101);
				
			}
		}
	}

	public static void main(String[] args) {
		
		ThreadPractice thread1 = new ThreadPractice();
		thread1.setName("T1");
		thread1.start();
		ThreadPractice thread2 = new ThreadPractice();
		thread2.setName("T2");
		thread2.start();
		
	}

}

package arrayPractice;

public class PrintRunnable implements Runnable {
	
	static int number=1;
	int remainder;
	int printUpTo=10;
	static Object lock=new Object();
	
	public PrintRunnable(int remainder) {
		super();
		this.remainder = remainder;
	}
	@Override
	public void run() {
		System.out.println("in run");
		while(number<printUpTo) {
			synchronized (lock) {
				while(number%2!=remainder) {
				try {
					System.out.println("");
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+","+number);
			number++;
			lock.notifyAll();
		}
		}
			
		
	}
	
	

}

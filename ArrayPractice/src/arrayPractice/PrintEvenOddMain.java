package arrayPractice;

public class PrintEvenOddMain {

	public static void main(String[] args) {
		System.out.println("in main");
		PrintRunnable oddRunnable=new PrintRunnable(1);
		PrintRunnable evenRunnable=new PrintRunnable(0);
		
		Thread t1=new Thread(oddRunnable,"ODD");
		Thread t2=new Thread(evenRunnable,"EVEN");
		
		t1.start();
		t2.start();
		

	}

}

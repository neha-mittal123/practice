package arrayPractice;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintEvenOddViaAtomicInteger {

	public static void main(String[] args) {
		AtomicInteger num=new AtomicInteger();
		Thread t1=new Thread(()-> {
			while(num.get()<=10) {
				if(num.get()%2==0) {
					System.out.println("even "+num.get());
					num.incrementAndGet();
				}
			}
		});
		Thread t2=new Thread(()-> {
			while(num.get()<=10) {
				if(num.get()%2!=0) {
					System.out.println("odd "+num.get());
					num.incrementAndGet();
				}
			}
		});
		t1.start();
		t2.start();
		

	}

}

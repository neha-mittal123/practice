package com.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockPractice {

	public static void main(String[] args) {
		final ReentrantLock lock1=new ReentrantLock();
		final ReentrantLock lock2=new ReentrantLock();
		Runnable task12=getRunnable(lock1,"lock1",lock2,"lock2");
		Runnable task21=getRunnable(lock2,"lock2",lock1,"lock1");
		Thread t1=new Thread(task12);
		Thread t2=new Thread(task21);
		t1.start();
		t2.start();
	}

	private static Runnable getRunnable(ReentrantLock lock1, String string, ReentrantLock lock2, String string2) {
		// TODO Auto-generated method stub
		
		return new Runnable() {
			
			@Override
			public void run() {
				try{
					if(lock1.tryLock(1,TimeUnit.SECONDS)) {
						System.out.println(string+" acquired by "+Thread.currentThread().getName());
						if(lock2.tryLock(1,TimeUnit.SECONDS)) {
							System.out.println(string2+" acquired by "+Thread.currentThread().getName());
							Thread.sleep(10);
						}else {
							System.out.println(string2+" couldn't acquired by"+Thread.currentThread().getName());
							lock1.unlock();
							System.out.println(string+" released in thread "+Thread.currentThread().getName());
						}
					}else {
						System.out.println(string+" couldn't acquired by"+Thread.currentThread().getName());
					}
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}finally{
					if(lock1.isHeldByCurrentThread())
						lock1.unlock();
					if(lock2.isHeldByCurrentThread())
						lock2.unlock();
				}
				
				
			}
		};
	}

}

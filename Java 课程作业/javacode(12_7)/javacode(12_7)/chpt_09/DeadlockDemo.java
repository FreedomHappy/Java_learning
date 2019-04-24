package chpt_09;

import java.awt.print.Book;
import java.util.concurrent.TimeUnit;

public class DeadlockDemo {

	public static void main(String[] args) {
		testDeadlock() ;
	}
	
	public static void testDeadlock() {
		GetTwoStuffsTask task1 = new GetTwoStuffsTask() ;
		GetTwoStuffsTask task2 = new GetTwoStuffsTask() ;
		task2.setFlag(false);
		
		Thread zsThread = new Thread(task1,"zs") ;
		Thread lsThread = new Thread(task2, "ls") ;
		zsThread.start();
		lsThread.start(); 
		System.out.println("the end of main thread ");
		
	}

}

class GetTwoStuffsTask implements Runnable {

	static Object pic = new Object();
	static Object book = new Object();
	boolean flag = true ;
	
	
	public void setFlag(boolean flag) {
		this.flag = flag ;
	}
	
	@Override
	public void run() {
		
		if (flag) {
			// zhangsan thread to do
			synchronized (pic) {
			
				System.out.println(Thread.currentThread().getName() 
						 + " got picture .");
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				
				System.out.println(Thread.currentThread().getName() 
						 + " want to get the book .");
				synchronized (book) {
					
					System.out.println(Thread.currentThread().getName() 
							 + " got the book .");
					
				}
				
			}
			
		} else {
		// lisi thread to do
			synchronized (book) {
				
				System.out.println(Thread.currentThread().getName() 
						 + " got book .");
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				
				System.out.println(Thread.currentThread().getName() 
						 + " want to get the pic .");
				synchronized (pic) {
					
					System.out.println(Thread.currentThread().getName() 
							 + " got the pic .");
					
				}
				
			}
			
			
			
		}
		
	}
	
	
}

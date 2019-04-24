package chpt_09;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.SystemException;

/**
 * create thread objects 
 * 
 * @author Ping
 * @date 2018年11月20日
 */
public class ThreadCreatDemo {

	public static void main(String[] args) {
		TaskTest();
		
		
	}
	public static void TaskTest() {
		
		PrintNumberTask task = new PrintNumberTask() ;
		//create three threads by one task
		Thread thread1 = new Thread(task,"PrintNumThread1") ;
		Thread thread2 = new Thread(task,"PrintNumThread2") ;
		Thread thread3 = new Thread(task,"PrintNumThread3") ;
		// start these threads 
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("This is main thread, and it was end! ");
		
		
		
		
		
	}
	
	public static void ThreadTest() {
		// create three thread objects
		Thread thread1 = new PrintNumberThread("PrintThread1") ;
		Thread thread2 = new PrintNumberThread("PrintThread2" ) ;
		Thread thread3 = new PrintNumberThread("PrintThread3" ) ;
		// start these threads 
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("This is main thread, and it was end! ");
		
	}

}

/**
 * define a thread subclass by extending Thread class
 * 
 * @author Ping
 * @date 2018年11月20日
 */
class PrintNumberThread extends Thread {
	
	public PrintNumberThread() {
		super("PrintNumberThread") ;
	}
	public PrintNumberThread(String name) {
		super(name) ;
	}
	
	@Override
	public void run() {
		// execution task 
		String threadName = this.getName();
		for (int i=0; i<10; i++) 
			System.out.println(threadName + " print : " + i);
	}

}

/**
 *  By implementing Runnable interface
 * 
 * @author Ping
 * @date 2018年11月20日
 */
class PrintNumberTask implements Runnable {
	@Override
	public void run() {
		// execution task 
		String threadName = Thread.currentThread().getName() ;
		for (int i=0; i<10; i++) 
			System.out.println(threadName + " print : " + i);
		
	}
	
	
}

class TicketSellThread extends Thread {
	
	private int ticketNum = 10 ;
	
	@Override 
	public void run() {
		
		if (ticketNum > 0) {
			System.out.println("sold one, and left " + (--ticketNum));
			//Thread.sleep(500); 
			//TimeUnit.SECONDS.sleep(1);
		}
		
	}
	
	
	
}










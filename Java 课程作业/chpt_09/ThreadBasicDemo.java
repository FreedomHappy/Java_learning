package chpt_09;

import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

/**
 * Thread basic
 * 
 * @author Ping
 * @date 2018年11月23日
 */
public class ThreadBasicDemo {

	public static void main(String[] args) {
		testCreatThreadByRunnable(); 
			
	}
	
	public static void testCreateThreadByExtending() {
// create three thread objects 
		Thread printThread1 = new PrintNumberThread("PrintThread1", 10) ;
		Thread printThread2 = new PrintNumberThread("PrintThread2", 10) ;
		Thread printThread3 = new PrintNumberThread("PrintThread3", 10) ;
		// start up
		System.out.println("Prority : printThread : " 
		               + printThread1.getPriority() 
		                + "main thread :"+  Thread.currentThread().getPriority());
		printThread1.setPriority(Thread.MAX_PRIORITY);
		printThread2.start();
		printThread3.start();
		printThread1.start();
		
		System.out.println("The end of main thread !");
				
	}
	
	public static void testCreatThreadByRunnable () {
		// create a runnable object
		PrintNumberTask printNumberTask = new PrintNumberTask("printTask-1", 10) ;
		// create a thread object by runnable  object
 		Thread thread1 = new Thread(printNumberTask) ;
 		Thread thread2 = new Thread(printNumberTask, "printTask-2") ;
 		Thread thread3 = new Thread(printNumberTask, "printTask-3") ;
 		
 		
 		thread1.start();
 		thread2.start();
 		thread3.start();
 		
 		System.out.println("the end of main thread " );
 		
		
		
	}

}

/**
 * define a thread class by extending super class Thread
 * 
 * @author Ping
 * @date 2018年11月23日
 */
class PrintNumberThread extends Thread {
	private int upperNum ; 
	public PrintNumberThread() {
		
	}
	public PrintNumberThread(String threadName , int upperNum) {
		super(threadName) ;
		this.upperNum  = upperNum ;
	}
	
	/**
	 * execution logic (task) ,  should be defined in run method .
	 */
	@Override
	public void run() {
		for (int i=0; i<this.upperNum ; i++) {
			System.out.println("Thread name : " + this.getName() + " : print " + i );
		}
	}
	
	
	
}

/**
 * define a thread task by implementing runnable interface 
 * 
 * @author Ping
 * @date 2018年11月23日
 */
class PrintNumberTask implements Runnable {
	private int upperNum ;
	private String name ; // for thread name 
	
	public PrintNumberTask(String name, int upperNum) {
		this.name = name ;
		this.upperNum = upperNum ;
	}
	
	@Override
	public void run() {
		
		for (int i=0; i<this.upperNum ; i++) {
			System.out.println("Thread name : " 
		               + Thread.currentThread().getName() 
		               + " : print " + i );
		}
		
	}
	
	
	
	
}














package chpt_09;

import java.util.concurrent.TimeUnit;

/**
 * Thread basic operations 
 * 
 * @author Ping
 * @date 2018Äê11ÔÂ27ÈÕ
 */
public class ThreadOperationDemo_02 {

	public static void main(String[] args) {
	//	testJoin();
	//	testSleepInterrupt(); 
	//	testInterrupted() ;
		testDaemon() ;
			
	}
	
	public static void testJoin() {
		
		PrintTask printTask = new PrintTask();
		Thread thread = new Thread(printTask, "PrintThread-1") ;
		
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		System.out.println("the end of main thread " );
	}
	
	public static void testSleepInterrupt() {
		PrintTask printTask = new PrintTask();
		Thread thread = new Thread(printTask, "PrintThread-1") ;
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		thread.interrupt(); 
		System.out.println("the end of main thread " );
		
		
	}
	
	public static void testInterrupted() {
		PrintTask printTask = new PrintTask();
		Thread thread = new Thread(printTask, "PrintThread-1") ;
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		thread.interrupt(); 
		System.out.println("the end of main thread " );
		
		
	}
	
	public static void testDaemon() {
		PrintTask printTask = new PrintTask();
		Thread thread = new Thread(printTask, "PrintThread-1") ;
		thread.setDaemon(true); 
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		System.out.println("the end of main thread " );
		
		
		
		
	}
	

}

class PrintTask implements Runnable {

	@Override
	public void run() {
		for ( int i=0; i>=0 ; i++) { // i<100000
//			try {
//				//Thread.sleep(1000) ;
//				TimeUnit.SECONDS.sleep(2) ;
//			} catch (InterruptedException e) {
//				System.out.println(Thread.currentThread().getName()
//						     + " was interrupted !");
//				return ;
//				//System.out.println(e.getMessage() );
//			}
			System.out.println(Thread.currentThread().getName() + " print i : " + i);
			
//			if (Thread.currentThread().isInterrupted()) {
//				System.out.println("The thread was interrupted, " 
//			                  + "and can be aborted ! ");
//				return ;
//				
//			}
			
			
			
		}
	}
	
	
	
}

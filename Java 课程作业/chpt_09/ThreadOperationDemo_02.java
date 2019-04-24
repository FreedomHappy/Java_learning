package chpt_09;

import java.util.concurrent.TimeUnit;

/**
 * Demo for thread operations
 * 
 * @author Ping
 * @date 2018Äê11ÔÂ30ÈÕ
 */
public class ThreadOperationDemo_02 {

	public static void main(String[] args) {

	//	testJoin();
	//	testSleep();
	//	testInterrupte() ;
		 testDaemon() ;
	}
	
	public static void testJoin() {
		
		PrintTask printTask = new PrintTask();
		Thread thread = new Thread(printTask, "Print-1") ;
		
		thread.start();
		try {
			thread.join(); // waiting until the thread was dead 
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		System.out.println("the end of main thread " );
	
	}
	public static void testSleep() {
		PrintTask printTask = new PrintTask();
		Thread thread = new Thread(printTask, "Print-1") ;
		
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt(); 
		System.out.println("the end of main thread " );
	}
	
	public static void testInterrupte() {
		PrintTask printTask = new PrintTask();
		Thread thread = new Thread(printTask, "Print-1") ;
		
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
		Thread thread = new Thread(printTask, "Daemon Thread - 1") ;
		thread.setDaemon(true); // daemon thread 
		
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		System.out.println("the end of main thread " );
	}
			
	
	
	
	
	

}


class PrintTask implements Runnable {

	@Override
	public void run() {
		//printTask() ;
		//sleepTask();
		//interrupteTask() ;
		 daemonTask()  ;
		
	}
	
	public void printTask() {
		for ( int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() 
					  + " print : i = " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
	}
	
	public void sleepTask() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
	}
	
	public void interrupteTask() {
		
		while(true) {
			System.out.println(Thread.currentThread().getName() + " is working .");
			if (Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().getName()
						       + " was interrupted !");
				return ;
			}
		}
		
	}
	
	public void daemonTask() {
		while(true) {
			System.out.println(Thread.currentThread().getName() 
					+ " is watching .");
		}
		
		
	}
	
	
}








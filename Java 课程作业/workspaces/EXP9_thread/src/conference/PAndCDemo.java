package conference;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class PAndCDemo {

	public static void main(String[] args) {
		testPAndB() ;
	}
	
	public static void testPAndB() {
		BaoziStore store = new BaoziStore(20) ;
		Producer producer = new Producer(store) ;
		Client client = new Client(store) ;
		
//		new Thread(producer, "Producer").start() ;
//		new Thread(client, "Client").start();
		
		new Thread(client, "Client").start();
		new Thread(producer, "Producer").start() ;
	}

}

class Baozi {
	
//	private String id ;
	private Date prodTime ;
	
	public Baozi() {
		prodTime = new Date() ;
	}
	
	public String toString() {
		return "BAOZI@(" + this.prodTime + " ) " ;
	}
	public Date getProdTime() {
		return this.prodTime ;
	}
	
}

class BaoziStore {
	
	private int maxSize ;
	private List<Baozi> baoziBuffer  ;
	
	public BaoziStore(int maxSize) {
		this.maxSize = maxSize ;
		this.baoziBuffer = new ArrayList<Baozi>() ;
	}
	
	
	public  void produceBaozi() {
		synchronized(this){
			while (this.baoziBuffer.size() == this.maxSize) {
				System.out.println("[INFO] the buffer was full !");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				
			}
			
			// produce baozi
			Baozi baozi = new Baozi();
			this.baoziBuffer.add(baozi) ;
			try {
				Thread.sleep(500) ;
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
			System.out.println(baozi + " was produced by " 
					 + Thread.currentThread().getName() );
			this.notifyAll(); 		
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void buyBaozi() {
		
		while (this.baoziBuffer.size() == 0) {
			System.out.println("[INFO] the buffer was empty !");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
			
		}
		// buy baozi
		Baozi baozi = this.baoziBuffer.remove(0) ;
		try {
			Thread.sleep(100) ;
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		System.out.println(baozi + " was sought by " 
				 + Thread.currentThread().getName() );
		this.notifyAll(); 
	} 
	
}

class Producer implements Runnable {

	private BaoziStore store ;
	
	public Producer(BaoziStore store) {
		this.store = store ;
	}
	@Override
	public void run() {
		
		for (int i=0; i<10; i++ )
			store.produceBaozi(); 
	}
	
}

class Client implements Runnable {

	private BaoziStore store ;
	
	public Client(BaoziStore store) {
		this.store = store ;
	}
	@Override
	public void run() {
		
		for (int i=0; i<10; i++ )
			store.buyBaozi(); 
	}
	
	
}









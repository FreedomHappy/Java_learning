package conference;



public class WaitAndNotifyDemo {

	public static void main(String[] args) {

//		testWait(); 
		testWaitAndNotify() ;
	}
	
	public static void testWait() {
		Resource resource = new Resource() ;
		ConsumeTask task = new ConsumeTask(resource) ;
		new Thread(task, "Consumer ").start();
		
	}
	
	public static void testWaitAndNotify() {
		Resource resource = new Resource() ;
		ConsumeTask con = new ConsumeTask(resource) ;
		ProduceTask pro = new ProduceTask(resource) ;
		
//		new Thread(pro,"Producer").start();
//		new Thread(con, "Consumer ").start();
		
		new Thread(con, "Consumer ").start();
		new Thread(pro,"Producer").start();
		
		
	}

}

class Resource {
	
	private String id ;
	public Resource() {
		
	}
	public synchronized void consume() {
		
		while (this.id == null ) {
			System.out.println(Thread.currentThread().getName() 
					 + " is waiting ."); 
			try {
				this.wait(); 
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
	
		System.out.println("resource " + this.id + " was consumed by " 
		          + Thread.currentThread().getName() 
					);
		this.notify();
		
	}
	
	public synchronized void produce() {

		while (this.id != null ) {
			System.out.println(Thread.currentThread().getName() 
					 + " is waiting ."); 
			try {
				this.wait(); 
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
		this.id = "id_1" ;
		System.out.println("resource " + this.id + " was produced by " 
					          + Thread.currentThread().getName() 
				);
		this.notify();
		
	}
	
}

class ConsumeTask implements Runnable {
	Resource toConsume ;
	
	public ConsumeTask(Resource toConsume) {
		this.toConsume = toConsume ;
	}

	@Override
	public void run() {// TODO Auto-generated method stub
		toConsume.consume(); 
	}
	
}

class ProduceTask implements Runnable {
	Resource toProduce ;
	
	public ProduceTask(Resource toProduce) {
		this.toProduce = toProduce ;
	}

	@Override
	public void run() {// TODO Auto-generated method stub
		toProduce.produce(); 
	}
	
}

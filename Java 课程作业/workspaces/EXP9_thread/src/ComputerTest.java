import com.sun.org.apache.regexp.internal.recompile;

/**  
* @Title: ComputerTest.java  
* @Package   
* @Description: TODO  
* @author:小豪
* @date 2018年12月7日  
* @version V1.8
*/

/**  
* @ClassName: ComputerTest  
* @Description: TODO
* @author 小豪  
* @date 2018年12月7日  
*    
*/
public class ComputerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		computerThreadTest();
	}
	public static void computerThreadTest() {
		ComputerStore computerStore = new ComputerStore();
		ProduceTask produceTask = new ProduceTask(computerStore);
		SellTask sellTask = new SellTask(computerStore);
		
		Thread proThread = new Thread(produceTask,"produceThread");
		Thread sellThread = new Thread(sellTask,"sellThread");
		proThread.start();
		sellThread.start();
		try {
			proThread.join();
			sellThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("end of main!");
	}
}



class Computer{
	private String ID;
	public Computer(String i) {
		this.ID = i;
	}
	public String getID() {
		return this.ID;
	}
}


class ComputerStore{
	private Computer computer;
	private int computerNum=0;
	public ComputerStore() {
		// TODO Auto-generated constructor stub
	}
	public int getComputerNum() {
		return this.computerNum;
	}
	public void produce() {
		synchronized (this) {
			while(computer != null) {
				System.out.println(Thread.currentThread().getName()+" is waiting!");
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String id = Integer.toString((++this.computerNum));
			this.computer = new Computer(id);
			System.out.println(Thread.currentThread().getName()
					+" produce a computer,id is "+this.computer.getID());
			this.notify();
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sell() {
		synchronized (this) {
			while(computer == null) {
				System.out.println(Thread.currentThread().getName()+" is waiting!");
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.computer = null;
			System.out.println(Thread.currentThread().getName()+" sell a computer");
			this.notify();
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class ProduceTask implements Runnable{
	private ComputerStore computerStore;
	public ProduceTask(ComputerStore cs) {
		this.computerStore = cs;
	}
	public void run() {
		for(int i=0 ; i<4; i++) {
			this.computerStore.produce();
		}
		System.out.println("Computer Store produce:"+
				this.computerStore.getComputerNum()+" computer");
	}
}

class SellTask implements Runnable{
	private ComputerStore computerStore;
	public SellTask(ComputerStore cs) {
		this.computerStore = cs;
	}
	public void run() {
		for (int i=0; i<4; i++) {
			this.computerStore.sell();
		}
	}
}
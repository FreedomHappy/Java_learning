package conference;

import java.util.concurrent.TimeUnit;


public class SynchronizedDemo {

	public static void main(String[] args) {
		testMoney();
	}
	
	public static void  testMoney() {
		
		Account account = new Account(10000.0f) ;
		
		SaveTask saveTask = new SaveTask(account) ;
		WithdrawTask withdrawTask = new WithdrawTask(account) ;
		
		Thread saveThread = new Thread(saveTask) ;
		Thread withdrawThread = new Thread(withdrawTask) ;
		
		saveThread.start();
		withdrawThread.start();
		
		try {
			saveThread.join() ;
			withdrawThread.join() ;
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		
		System.out.println("Finally, the left money is " + account.getMoney() );
	}

}


class Account {
	private float money ;
	
	public Account() {
		
	}
	public Account(float money) {
		this.money = money ;
	}
	
	//public synchronized void addMoney(float value) {
	public void addMoney(float value) {
		System.out.println("Other irrelevent codes .") ;
		// other codes irrelated to update this.money 
		synchronized(this) {
			// following critical section for this.money attribute
			float temp = this.money ;
			try {
				TimeUnit.MILLISECONDS.sleep(500) ;
			} catch (InterruptedException e ) {
				e.printStackTrace(); 
			}
			temp  += value ;
			this.money = temp ;
		}
		System.out.println("add : " + value + " , left money : " + this.money);
	}
	
	
	//public synchronized void reduceMoney(float value) {
	public void reduceMoney(float value) {
		System.out.println("Other irrelevent codes .") ;
		//Object object = new Object() ;
		// other codes irrelated to update this.money 
		synchronized (this) { 
			float temp = this.money ;
			try {
				TimeUnit.MILLISECONDS.sleep(500) ;
			} catch (InterruptedException e ) {
				e.printStackTrace(); 
			}
			if ( temp < value ) {
				System.out.println("the account does not have enough money ! " );
				return ;
			}
			temp  -= value ;
			this.money = temp ;
		}
		System.out.println("reduce : " + value + " , left money :" + this.money);
	}
	public float getMoney() {
		return this.money ;
	}
}

class SaveTask implements Runnable {
	private Account account ;
	
	public SaveTask(Account account) {
		this.account = account ;
	}
	
	@Override
	public void run() {
		for ( int i=0; i<10; i++)
			account.addMoney(1000);
	}
	
}
class WithdrawTask implements Runnable {
	private Account account ;
	
	public WithdrawTask(Account account) {
		this.account = account ;
	}
	
	@Override
	public void run() {
		for ( int i=0; i<10; i++)
			account.reduceMoney(1000);
	}
	
}
















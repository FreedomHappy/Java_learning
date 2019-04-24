package chpt_09;

import java.util.concurrent.TimeUnit;

import org.junit.experimental.theories.Theories;
import org.omg.CORBA.SystemException;

/**
 *  for synchronized demo
 * 
 * @author Ping
 * @date 2018Äê11ÔÂ27ÈÕ
 */
public class SynchronizedDemo {

	public static void main(String[] args) {
		Account account = new Account(10000) ;
		SaveTask saveTask = new SaveTask(account) ;
		WithdrawTask withdrawTask = new WithdrawTask(account) ;
		
		Thread save = new Thread(saveTask) ;
		Thread withdraw = new Thread(withdrawTask) ;
		
		save.start(); 
		withdraw.start(); 
		
		try {
			save.join() ;
			withdraw.join() ;
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		account.printInfor(); 
	}

}


class Account {
	private int money ;
	public Account() {
		
	}
	public Account(int money) {
		this.money = money ;
	}
	public synchronized void addMoney(int money) {
		int temp = this.money ;
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		temp += money ;
		this.money = temp ;
	//	this.money += money ;
		System.out.println("the account was added by " 
		                             + money 
				                     + " and tatal money was " + this.money);
	}
	public synchronized void reduceMoney(int money) {
		int temp = this.money ;
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		if (temp < money ) {
			System.out.println("the money is not enought to reduce .");
			return ;
		}
		temp -= money ;
		
		this.money = temp ;
	//	this.money -= money ;
		System.out.println("the account was reduced by " 
                + money 
                + " and tatal money was " + this.money);
	}
	
	public void printInfor() {
		System.out.println("the tatal money was " + this.money);
	}
	
}

class SaveTask implements Runnable {
	private Account account ;
	public SaveTask(Account account) {
		this.account = account ;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			this.account.addMoney(1000);
		}
		
	}
	
}

class WithdrawTask implements Runnable {
	private Account account ;
	public WithdrawTask(Account account) {
		this.account = account ;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			this.account.reduceMoney(1000);
		}
		
	}
	
}








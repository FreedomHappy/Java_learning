
/**  
* @Title: testAccount.java  
* @Package account  
* @Description: TODO  
* @author:lenovo
* @date 2018年11月25日  
* @version V1.8
*/  


package account;

import java.awt.datatransfer.FlavorTable;
import java.util.concurrent.TimeUnit;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.org.apache.xml.internal.security.Init;

/**  
* @ClassName: testAccount  
* @Description: TODO
* @author lenovo  
* @date 2018年11月25日  
*    
*/
public class testAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testThread();
		
	}
	public static void testThread(){
		Account account = new Account(10000);
		Bank bank = new Bank(account);
		Company company = new Company(account);
		Thread threadBank = new Thread(bank,"threadBank");
		Thread threadCompany = new Thread(company,"threadBank");
		threadBank.start();
		threadCompany.start();
		try {
			threadBank.join() ;
			threadCompany.join() ;
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		System.out.println("The end of main thread !");
		
	}

}
//公司任务类
class Company implements  Runnable {
	private Account account;
	Company(){
	}
	Company(Account acc){
		this.account = acc;
	}
	public void run() {
		for(int i=0; i<10; i++){
			this.account.addMoney(1000);
		}
	}
}
//银行任务类
class Bank implements  Runnable {
	private Account account;
	Bank(){
	}
	Bank(Account acc){
		this.account = acc;
	}
	public void run() {
		for(int i=0; i<10; i++){
			this.account.reduceMoney(1000);
		}
	}
}
//账户类
class Account{
	private float rest;
	
	public Account(){
		this.rest = 0;
	}
	public Account(float init_money){
		this.rest = init_money;
	}
	public float getRest(){
		return this.rest;
	}
	public void addMoney(float add){
		synchronized (this) {
			float temp = this.rest;
			try {
				TimeUnit.MILLISECONDS.sleep(500) ;
			} catch (InterruptedException e ) {
				e.printStackTrace(); 
			}
			System.out.println("add money:"+add);
			temp += add;
			this.rest = temp;
		}
		System.out.println("the rest:"+this.rest);
	}
	public void reduceMoney(float reduce){
		synchronized (this) {
			float temp = this.rest;
			try {
				TimeUnit.MILLISECONDS.sleep(500) ;
			} catch (InterruptedException e ) {
				e.printStackTrace(); 
			}
			if ((temp-reduce)<0){
				System.out.println("rest not enough!");
				return;
			}
			temp -= reduce;
			this.rest = temp;
		}
		System.out.println("the rest:"+this.rest);
	}
}


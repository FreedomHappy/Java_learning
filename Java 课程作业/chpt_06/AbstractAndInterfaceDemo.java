package chpt_06;

public class AbstractAndInterfaceDemo {

	public static void main(String[] args) {
		InteliDevice phone = new CellPhone();
		InteliDevice laptop = new Laptop() ;
		
		doCommunicate(phone);
		doEntertain(laptop);
		

	}
	
	public static void doCommunicate(Communicate com) {
		 com.communicate(); 
	}
	public static void doEntertain(Entertainment entertain) {
		entertain.playMedia(); 
	}

}


interface Communicate {
	/**
	 * 
	 * @function communication 
	 */
	public void communicate() ;
}

interface Entertainment {
	/**
	 * 
	 * @function play media for fun
	 */
	public void playMedia() ;
}


abstract class InteliDevice implements Communicate, Entertainment {
	
	@Override
	public void communicate() {
		System.out.println("use WECHAT to communicate !");
		
	}
	
}

class CellPhone extends InteliDevice {
	public CellPhone() {
		System.out.println("A HUAWEI phone was created !" );
	}
	@Override
	public void playMedia() {
		System.out.println("use QQMovice to play media !");
	}
	
	
	
}
class Laptop extends InteliDevice {
	public Laptop() {
		System.out.println("A LENOVO laptop was created !" );
		
	}
	@Override
	public void playMedia() {
		System.out.println("use Kugou to play media !");
	}
	
	
	
}



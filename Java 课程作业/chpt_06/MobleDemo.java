package chpt_06;

public class MobleDemo {

	public static void main(String[] args) {
		SIM mobileSIM = new SIMOfChinaMobile("123456789") ;
		MobilePhone phone  = new MobilePhone(mobileSIM)  ;
		phone.printInfor(); 
		SIM unicomSIM = new SIMOfChinaUnicom("987654321") ;
		phone.replaceSIM(unicomSIM);
		phone.printInfor(); 
		// new extension 
		SIM telecomSIM = new SIMOfTeleCome("1234456767") ;
		phone.replaceSIM(telecomSIM); 
		phone.printInfor();
		
		
	}

}


class MobilePhone {
	
	SIM card ; 
	public MobilePhone () {
		
	}
	public MobilePhone(SIM card) {
		this.card = card ;
	}
	
	
	public void replaceSIM(SIM card) {
		this.card = card ;
	}
	
	public void printInfor() {
		System.out.println(card.getInfor());
	}
}



abstract class SIM {
	
	String num ;
	
	public SIM() {
		
	}
	
	public SIM(String num) {
		this.num = num ;
	}
	
	public void setNum(String num) {
		this.num = num ;
	}
	public String getNum() {
		return this.num ;
	}
	/**
	 * 
	 * @function get the infor of SIM
	 * @return
	 */
	public abstract String getInfor();
	
}


class SIMOfChinaMobile extends SIM {

	public SIMOfChinaMobile() {
	}
	public SIMOfChinaMobile(String num) {
		super(num) ;
	}
	@Override
	public String getInfor() {
		
		return "Welcome to use ChinaMobile : " + this.num ;
	}
	
	
}
 

class SIMOfChinaUnicom extends SIM {

	public SIMOfChinaUnicom() {
	}
	public SIMOfChinaUnicom(String num) {
		super(num) ;
	}
	@Override
	public String getInfor() {
		return "Welcome to use ChinaUnicom : " + this.num ;

	}
	
	
}


class SIMOfTeleCome extends SIM {
	public SIMOfTeleCome() {
	}
	public SIMOfTeleCome(String num) {
		super(num) ;
	}
	@Override
	public String getInfor() {
		return "Welcome to use Telecom : " + this.num ;

	}
	
	
}
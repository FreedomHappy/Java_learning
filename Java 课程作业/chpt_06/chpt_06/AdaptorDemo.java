package chpt_06;
/**
 * Adaptor demo :
 *  roles :  
 *  Target(interface) , 
 *  Adaptor  , 
 *  TobeAdapted (existed interface or class)
 * @author lenovo
 *
 */
public class AdaptorDemo {

	public static void main(String[] args) {

		Client.cellPhoneCharge(new VoltAdaptor(new HomeCharger()));
	}

}

/**
 * ����Ŀ��
 * @author lenovo
 *
 */
interface FiveVoltCharger {
	public int fiveVoltCharge() ;
}

// Ӧ��
class Client {
	public static void cellPhoneCharge(FiveVoltCharger fiveVoltCharger  ) {
		fiveVoltCharger.fiveVoltCharge() ;
	}
}


// ��ǰ���������
class HomeCharger {
	
	public int homeUsingCharger() {
		return 220 ;
	}
	
}
// ������
class VoltAdaptor implements FiveVoltCharger {

	private HomeCharger homeCharger ; // ��������
	
	public VoltAdaptor() {
		
	}
	public VoltAdaptor(HomeCharger homeCharger) {
		this.homeCharger = homeCharger ;
	} 
	@Override
	public int fiveVoltCharge() {
		// ����ľ����߼�
		int volt = homeCharger.homeUsingCharger() ;
		return reduceVolt(volt) ;
	}
	
	private int reduceVolt(int oldVolt) {
		// .......
		return 5 ;
	}
	
	
	
	
	
	
}










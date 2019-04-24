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
 * 适配目标
 * @author lenovo
 *
 */
interface FiveVoltCharger {
	public int fiveVoltCharge() ;
}

// 应用
class Client {
	public static void cellPhoneCharge(FiveVoltCharger fiveVoltCharger  ) {
		fiveVoltCharger.fiveVoltCharge() ;
	}
}


// 当前类或被适配类
class HomeCharger {
	
	public int homeUsingCharger() {
		return 220 ;
	}
	
}
// 适配类
class VoltAdaptor implements FiveVoltCharger {

	private HomeCharger homeCharger ; // 被适配类
	
	public VoltAdaptor() {
		
	}
	public VoltAdaptor(HomeCharger homeCharger) {
		this.homeCharger = homeCharger ;
	} 
	@Override
	public int fiveVoltCharge() {
		// 适配的具体逻辑
		int volt = homeCharger.homeUsingCharger() ;
		return reduceVolt(volt) ;
	}
	
	private int reduceVolt(int oldVolt) {
		// .......
		return 5 ;
	}
	
	
	
	
	
	
}










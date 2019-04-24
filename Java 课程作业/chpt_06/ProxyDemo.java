package chpt_06;
/**
 * ProxyDemo
 * 
 * include roles:   Proxy, Real , Client , interface
 * 
 * @author Ping
 * @date 2018��11��9��
 */
public class ProxyDemo {

	public static void main(String[] args) {
		StuClient.app(new EleProxy(new FoodShop()));
	}

}


interface ForMeal {
	
	public void buyFood() ;
}




class StuClient {
	
	public static void app(ForMeal forMeal) {
		forMeal.buyFood();
	}
	
	
}


class FoodShop implements ForMeal {

	@Override
	public void buyFood() {
		System.out.println("providing �߰˶�");
		
	}
	
}

class EleProxy implements ForMeal {
	
	private FoodShop foodShop ; // real shop��������  : ��̬����
	
	public EleProxy() {
		
	}
	public EleProxy(FoodShop foodShop) {
		this.foodShop = foodShop ;
	}

	@Override
	public void buyFood() {
		System.out.println(" order was given " ) ; // preAction  advice
		foodShop.buyFood(); 
		System.out.println(" delivering food . "); // postAction
		
		
	}
	
	
	
	
	
	
	
}

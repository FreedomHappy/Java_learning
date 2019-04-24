package chpt_06;
/**
 * ProxyDemo
 * 
 * include roles:   Proxy, Real , Client , interface
 * 
 * @author Ping
 * @date 2018年11月9日
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
		System.out.println("providing 高八斗");
		
	}
	
}

class EleProxy implements ForMeal {
	
	private FoodShop foodShop ; // real shop被代理者  : 静态代理
	
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

package chpt_06;

public class ProxyDemo_06 {

	public static void main(String[] args) {
		
		new Client().eatFood(new EleProxy()) ;

	}

}

class Client {
	public void eatFood(FoodProvider foodProvider) {
		// lots of things to do 
		foodProvider.buyFood(); 
		// lots of things to do 
	}
}

interface FoodProvider {
	public void buyFood() ;
}

class FoodShop implements FoodProvider {

	@Override
	public void buyFood() {
		System.out.println("you got ¸ß°Ë¶·food.");
		
	}
	
}

class EleProxy implements FoodProvider {
	private FoodProvider provider ;
	
	public EleProxy() {
		System.out.println(" you are using Ele platform " );
	}
	@Override
	public void buyFood() {
		
		this.processOrder();  // preAction() ;
		provider = new FoodShop(); 
		provider.buyFood();  // action
		this.delivery();  // postAction
		
		
	}
	
	private void processOrder() {
		System.out.println(" Order processing ....and then decide one foodshop") ;
	}
	
	private  void delivery() {
		System.out.println("delivery food to client" );
	}
	
	
	
	
}




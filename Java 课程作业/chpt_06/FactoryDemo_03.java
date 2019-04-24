package chpt_06;
/**
 * Simple Factory demo
 * 
 * @author Ping
 * @date 2018Äê11ÔÂ9ÈÕ
 */
public class FactoryDemo_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


interface Fruit {
	
	public void canEat() ;
}


class Apple implements Fruit {

	@Override
	public void canEat() {
		System.out.println(" Apple fruit .") ;
		
	}
	
}


class Client {
	
	public static void eatFruit() {
	
		new Apple().canEat(); 
		FruitFactory.getFruit("apple").canEat();
		FruitFactory.getFruit("lichi").canEat(); 
	
	}
	public static void eatFruit(Fruit fruit) {
		fruit.canEat(); 
	}
}



class Youzi implements Fruit {

	@Override
	public void canEat() {
		System.out.println(" Youzi fruit .") ;
		
	}
	
}

class Lichi implements Fruit {

	@Override
	public void canEat() {
		System.out.println(" Lichi fruit .") ;
		
	}
	
}

class Orange implements Fruit {

	@Override
	public void canEat() {
		System.out.println(" Orange fruit .") ;
		
	}
	
}

class FruitFactory {
	
	/**
	 *  common action to save resources
	 * @function
	 */
	public static void configure() {
		
	}
	/**
	 * 
	 * @function create fruit object based on given parameter
	 * @param type
	 * @return
	 */
	public static Fruit getFruit(String type) {
		
		if ( "apple".equals(type)) {
			return new Apple();
		} else if ("youzi".equals(type)) {
			return new Youzi() ;
		} else if ("orange".equals(type)) {
			return new Orange();
		}
		return null ;
		
		
		
	}
	
	
	
	
	
	
}






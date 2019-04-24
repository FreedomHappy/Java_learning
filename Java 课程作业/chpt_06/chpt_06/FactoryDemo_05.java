package chpt_06;
/**
 * Simple factory pattern demo
 * 
 * @author Ping
 * @date 2018Äê11ÔÂ6ÈÕ
 */
public class FactoryDemo_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void eatFujianFruit() {
		FujianFruitFactory factory = new FujianFruitFactory() ;
		Fruit fruit = factory.getFruit("lichi") ;
		Fruit fruit1 = factory.getFruit("youzi") ;
		
	}
	
	public static void eatFruit() {
		
		Fruit apple = new Apple();
		apple.eat() ;
		Fruit orange = new Orange();
		orange.eat() ;
		
	}

}


interface Fruit {
	
	public void eat() ;
}


class Apple implements Fruit {

	@Override
	public void eat() {
		
	}
	
}

class Orange implements Fruit {

	@Override
	public void eat() {
		
	}
	
}

class Youzi implements Fruit {
	@Override
	public void eat() {
		
	}
}

class Lichi implements Fruit {
	@Override
	public void eat() {
		
	}
}

abstract class FruitFactory {
	
	public abstract Fruit getFruit(String type) ;
}

class FujianFruitFactory extends FruitFactory {

	@Override
	public Fruit getFruit(String type) {
		if ( type.equals("youzi")) {
			return new Youzi();
		}else if (type.equals("lichi")) {
			return new Lichi() ;
		}
		return null;
	}
}











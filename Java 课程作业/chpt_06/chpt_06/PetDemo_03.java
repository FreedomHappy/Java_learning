package chpt_06;



public class PetDemo_03 {
	
	public static void main(String args[] ) {
		
		Pet pet = new Cat("001","white",2,21.0f) ;
		System.out.println(pet.isSellable(50.0f)) ;
		pet.shout(); 
		
		
	}

}


abstract class Pet {
	String id ;
	String color ;
	int age;
	float price ;
	
	public Pet() {
		
	}
	
	public Pet(String id, String color , int age, float price) {
		this.id = id ;
		this.age = age ;
		this.color = color ;
		this.price = price ;
	}
	
	/**
	 * an abstract method
	 * @function decide  if the pet is sellable based on the offer value 
	 * @param offer
	 * @return 
	 */
	public abstract boolean isSellable(float offer) ;
	
	/**
	 * 
	 * @function shout behavior 
	 */
	public abstract void shout() ;
	
	
}

class Cat extends Pet {
	
	public Cat() {
		
	}
	
	public Cat(String id, String color , int age, float price) {
		super(id, color, age,price) ;
		System.out.println("A cat was created !");
	}

	@Override
	public boolean isSellable(float offer) {
		
		return offer > this.price * (1 + 0.2);
	}

	@Override
	public void shout() {
		System.out.println("miao miao  ....." );
		
	}
	
}

class Dog extends Pet {

	@Override
	public boolean isSellable(float offer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		
	}
	
	
}
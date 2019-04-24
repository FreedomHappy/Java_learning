package chpt_06;
/**
 *  ploymorphism demo
 * 
 * @author Ping
 * @date 2018年11月9日
 */
public class PloyDemo_02 {

	public static void main(String[] args) {
		
		Pet pet = new Cat();
		Cat cat = (Cat) pet ; // 向下转型
		
		pet.petMethod();  // pet形态
	
		cat.petMethod();  // cat形态
		cat.catMethod(); 
		System.out.println( pet instanceof Cat );
		System.out.println( pet instanceof Pet );
		

	}

}


class Pet {
	public void petMethod() {
		System.out.println("this is pet action " );
	}
}

class Cat extends Pet {
	
	public void catMethod() {
		System.out.println("this is cat action " );
	}
}

class Dog extends Pet {
	public void dogMethod() {
		System.out.println("this is dog action " );
	}
	
}






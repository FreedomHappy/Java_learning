package chpt_06;
/**
 *  ploymorphism demo
 * 
 * @author Ping
 * @date 2018��11��9��
 */
public class PloyDemo_02 {

	public static void main(String[] args) {
		
		Pet pet = new Cat();
		Cat cat = (Cat) pet ; // ����ת��
		
		pet.petMethod();  // pet��̬
	
		cat.petMethod();  // cat��̬
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






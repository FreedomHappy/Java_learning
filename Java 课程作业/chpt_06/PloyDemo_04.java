package chpt_06;

public class PloyDemo_04 {

	public static void main(String[] args) {
		
		ACat cat = new ACat();
		APet pet = cat ; // 向上转型
		pet.action();
		cat = (ACat) pet ; // 向下转型
		cat.catAction(); 
		
		// instanceof 
		if (pet instanceof ACat) {
			System.out.println(true);
		}
		
		
		

	}

}


abstract class APet {
	
	public abstract void action() ;
	
}

class ADog extends APet {
	public ADog () {
		System.out.println("this is a dog ");
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}
	
	
}

class ACat extends APet {
	public ACat () {
		System.out.println("this is a cat");
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}
	
	public void catAction() {
		
	}
}


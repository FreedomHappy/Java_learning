package chpt_06;

public class FinalDemo_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//final 
class Final {
	
	final String str = "hello" ;
	public static final String STR = "hello" ;
	public static String Infor = "hello" ;
	
	public Final() {
		
	}
	public Final(String str) {
		//this.str = str ;
	}
	public final void finalMethod() {
		
	}
	
}

class Subclass extends Final {
	
//	@Override
//	public void finalMethod() {
//		
//	}
	
}



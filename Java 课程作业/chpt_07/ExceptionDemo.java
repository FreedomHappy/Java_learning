package chpt_07;
/**
 * Exception demo
 * 
 * @author Ping
 * @date 2018Äê11ÔÂ16ÈÕ
 */
public class ExceptionDemo {

	public static void main(String[] args) {
		int var = 0 ;
		
		
		try {
			System.out.println(1/var) ;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
		System.out.println("Other infor after........");
		System.out.println("Other infor after........");
		System.out.println("Other infor after........");
		System.out.println("Other infor after........");
		System.out.println("Other infor after........");
		
	}

}

package chpt_10;

import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class RegexDemo {

	public static void main(String[] args) {
	//	testStringRegexForMatch(); 
	//	testStringRegexForReplace() ;
		testStringRegexForSplit() ;
	}
	
	public static void testStringRegexForMatch() {
		
		Scanner scanner = new Scanner(System.in) ;
		String email = null ;
		// regex string for valid email
		String regex = "\\w+@\\w+\\.(\\w+\\.)*(com|cn|org)" ;
		
	
		
		do {
			System.out.println("please input your email addr: ");
			email = scanner.nextLine();
			if (email.matches(regex)) {
				System.out.println("It is a valided email .");
			} else {
				System.out.println("It is not a valided one .");
			}
			
		}while(true) ;
		
	}
	public static void testStringRegexForReplace() {
		String text = "dfdfdfdf123fdfndnfidnifdif567dfdfdfdf" ;
		String regex = "\\d" ;
		String replacement = "*" ;
		
		System.out.println("before replacement : ");
		System.out.println(text); 
		System.out.println("after replacement : ");
		System.out.println(text.replaceAll(regex, replacement) );
	}
	public static void testStringRegexForSplit() {
		String text = "dfdfdfdf123fdfndnfidnifdif567dfdfdfdf" ;
		String regex = "\\D+" ;
	
		System.out.println("before splitted : ");
		System.out.println(text); 
		System.out.println("after splitted : ");
		String[] subStrings = text.split(regex) ;
		int sum = 0  ;
		for (String string : subStrings) {
			if (! "".equals(string)) {
				System.out.println(string);
				sum += Integer.parseInt(string) ;
			}
				
		}
		System.out.println("the sum is " + sum);
		
		
	}

}

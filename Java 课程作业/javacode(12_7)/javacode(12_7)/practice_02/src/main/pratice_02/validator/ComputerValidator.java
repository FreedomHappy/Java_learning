package main.pratice_02.validator;

import java.util.Scanner;

public abstract class ComputerValidator implements Validator {
	private static Scanner scanner = new Scanner(System.in) ;
	protected Computer computer ;
	public ComputerValidator(Computer computer) {
		this.computer = computer ;
	}
	
	public String inputMsg(String type) {
		System.out.println("************ID - Validation ****************");
		System.out.printf("*  hello, please input your account for %s ID-Validation: \n", type);
		
		String ms ="";
		do {
			ms = scanner.nextLine();
		} while ("".equals(ms.trim())) ;
		
		return ms ;
	
	}
	

}
